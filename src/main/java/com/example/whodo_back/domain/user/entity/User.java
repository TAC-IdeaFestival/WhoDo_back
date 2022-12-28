package com.example.whodo_back.domain.user.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.springframework.web.bind.annotation.CrossOrigin;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Getter
@Table(name = "member")
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class User {
    @Id
    private String email;
    private String name;
    private String password;
    private Integer classNum;
}
