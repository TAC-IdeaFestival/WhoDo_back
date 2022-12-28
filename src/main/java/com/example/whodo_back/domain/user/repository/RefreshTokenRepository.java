package com.example.whodo_back.domain.user.repository;

import com.example.whodo_back.domain.user.entity.RefreshToken;
import org.springframework.data.repository.CrudRepository;

import java.util.Optional;

public interface RefreshTokenRepository extends CrudRepository<RefreshToken, String> {
    Optional<RefreshToken> findRefreshTokenByEmail(String email);
}