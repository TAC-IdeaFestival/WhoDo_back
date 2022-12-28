package com.example.whodo_back.domain.user.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;
import org.springframework.data.redis.core.RedisHash;
import org.springframework.data.redis.core.TimeToLive;
import org.springframework.data.redis.core.index.Indexed;

import javax.persistence.Id;

@Getter
@NoArgsConstructor
@AllArgsConstructor
@ToString
@RedisHash(value = "refreshToken")
public class RefreshToken {
    @Indexed
    private String email;

    @Id
    private String token;

    @TimeToLive
    private Long expiredAt;

    public void exchangeRefreshToken(String token) {
        this.token = token;
    }
}