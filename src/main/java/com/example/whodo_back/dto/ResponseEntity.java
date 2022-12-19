package com.example.whodo_back.dto;

import com.example.whodo_back.domain.Member;
import lombok.*;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class ResponseEntity {
    private Long id;
    private String schoolNumber;
    private String name;
    private String userid;
    private String password;

    public Member memberEntity(){
        return Member.builder()
                .id(this.id)
                .schoolNumber(this.schoolNumber)
                .name(this.name)
                .userid(this.userid)
                .password(this.password)
                .build();
    }

}
