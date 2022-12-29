package com.example.whodo_back.domain.user.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Getter
@Table(name = "user")
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class User {
    @Id
    private String email;

    @Column(nullable = false)
    private String name;

    @Column(nullable = false)
    private String password;

    @Column(nullable = false)
    private Integer classNum;

    @Enumerated(EnumType.STRING)
    private Role role;

    @PrePersist
    public void prePersist(){
        this.role = this.role == null ? Role.STUDENT : Role.TEACHER;
    }
}
