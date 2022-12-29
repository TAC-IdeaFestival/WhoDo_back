package com.example.whodo_back.domain.user.presentation.dto.request;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;

@Getter
@AllArgsConstructor
@NoArgsConstructor
public class SignInRequest {
    @Email
    @NotBlank(message = "이메일은 필수 입력값입니다")
    private String email;
    @NotBlank(message = "비밀번호는 필수 입력값입니다")
    private String password;

}