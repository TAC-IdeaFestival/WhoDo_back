package com.example.whodo_back.domain.user.service;

import com.example.whodo_back.domain.user.entity.BlackList;
import com.example.whodo_back.domain.user.entity.RefreshToken;
import com.example.whodo_back.domain.user.entity.User;
import com.example.whodo_back.domain.user.exception.exceptionCollection.*;
import com.example.whodo_back.domain.user.presentation.dto.request.SignInRequest;
import com.example.whodo_back.domain.user.presentation.dto.request.SignUpRequest;
import com.example.whodo_back.domain.user.presentation.dto.response.SignInResponse;
import com.example.whodo_back.domain.user.repository.BlackListRepository;
import com.example.whodo_back.domain.user.repository.RefreshTokenRepository;
import com.example.whodo_back.domain.user.repository.UserRepository;
import com.example.whodo_back.global.security.jwt.JwtProvider;
import com.example.whodo_back.global.utils.UserUtil;
import lombok.RequiredArgsConstructor;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class UserService {
    private final UserRepository userRepository;
    private final RefreshTokenRepository refreshTokenRepository;
    private final BlackListRepository blackListRepository;
    private final PasswordEncoder passwordEncoder;
    private final JwtProvider jwtProvider;
    private final UserUtil userUtil;
    private final RedisTemplate redisTemplate;

    @Transactional(rollbackFor = Exception.class)
    public void signUp(SignUpRequest signupRequest) {
        if(userRepository.existsByEmail(signupRequest.getEmail())) {
            throw new DuplicatedUserEmailException("이메일이 중복되었습니다");
        }
        if (userRepository.existsByClassNum(signupRequest.getClassNum())) {
            throw new DuplicatedUserClassNumException("학번이 중복되었습니다");
        }
        User user = User.builder()
                .email(signupRequest.getEmail())
                .name(signupRequest.getName())
                .password(passwordEncoder.encode(signupRequest.getPassword()))
                .classNum(signupRequest.getClassNum())
                .build();
        userRepository.save(user);
    }

    @Transactional(rollbackFor = Exception.class)
    public SignInResponse signIn(SignInRequest signinRequest) {
        User user = userRepository
                .findUserByEmail(signinRequest.getEmail())
                .orElseThrow(()->new EmailNotFoundException("이메일을 찾지 못했습니다"));
        if(!passwordEncoder.matches(signinRequest.getPassword(), user.getPassword())){
            throw new WrongPasswordException("비밀번호가 올바르지 않습니다");
        }

        String accessToken = jwtProvider.generatedAccessToken(signinRequest.getEmail());
        String refreshToken = jwtProvider.generatedRefreshToken(signinRequest.getEmail());
        RefreshToken entityToRedis = new RefreshToken(signinRequest.getEmail(), refreshToken, jwtProvider.getREFRESH_TOKEN_EXPIRE_TIME());
        refreshTokenRepository.save(entityToRedis);
        return SignInResponse.builder()
                .accessToken(accessToken)
                .refreshToken(refreshToken)
                .expiredAt(jwtProvider.getExpiredAtToken())
                .build();

    }

    @Transactional(rollbackFor = Exception.class)
    public void logout(String accessToken) {
        User user = userUtil.currentUser();
        RefreshToken refreshToken = refreshTokenRepository.findRefreshTokenByEmail(user.getEmail()).orElseThrow(()-> new RefreshTokenNotFoundException("리프레시 토큰을 찾을 수 없습니다"));
        refreshTokenRepository.delete(refreshToken);
        saveBlackList(user.getEmail(), accessToken);
    }

    private void saveBlackList(String email, String accessToken) {
        if(redisTemplate.opsForValue().get(accessToken)!=null) {
            throw new BlackListAlreadyExistException("블랙리스트에 이미 등록되어있습니다");
        }
        BlackList blackList = BlackList.builder()
                .email(email)
                .accessToken(jwtProvider.validateTokenType(accessToken))
                .timeToLive(jwtProvider.getExpiredAtTokenToLong())
                .build();
        blackListRepository.save(blackList);
    }
}