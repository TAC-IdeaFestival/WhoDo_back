package com.example.whodo_back.global.utils;

import com.example.whodo_back.domain.user.entity.User;
import com.example.whodo_back.domain.user.exception.exceptionCollection.UserNotFoundException;
import com.example.whodo_back.domain.user.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class UserUtil {
    private final UserRepository userRepository;

    public User currentUser() {
        String email = SecurityContextHolder.getContext().getAuthentication().getName();
        return userRepository.findUserByEmail(email).orElseThrow(()->new UserNotFoundException("유저가 없습니다"));
    }
}
