package com.example.whodo_back.domain.user.repository;

import com.example.whodo_back.domain.user.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserRepository extends JpaRepository<User, String> {
    Boolean existsByEmail(String email);

    Boolean existsByClassNum(int classNum);

    Optional<User> findUserByEmail(String email);
}
