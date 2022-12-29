package com.example.whodo_back.domain.user.presentation.dto.request;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@Getter
@AllArgsConstructor
@NoArgsConstructor
public class SignUpRequest {

    @Email
    @NotBlank(message = "이메일은 필수 입력값입니다")
    private String email;
    @NotBlank(message = "이름은 필수 입력값입니다")
    private String name;
    @NotBlank(message = "비밀번호는 필수 입력값입니다")
    private String password;
    @NotNull(message = "학번은 필수 입력값입니다")
    private Integer classNum;
}
