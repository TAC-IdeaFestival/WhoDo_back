package com.example.whodo_back.domain.servey.dto;


import com.example.whodo_back.domain.servey.entity.SurveyForm;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import java.time.LocalDate;

@Getter
@NoArgsConstructor
public class SurveyCreateRequestDto {
    private Long formNum;

    private String title;

    private String content;

    private LocalDate deadLine;

    private String grade;

    @Builder
    public SurveyCreateRequestDto(Long formNum, String title, String content, LocalDate deadLine, String grade) {
        this.formNum = formNum;
        this.title = title;
        this.content = content;
        this.deadLine = deadLine;
        this.grade = grade;
    }

    public SurveyForm toEntity(){
        return SurveyForm.builder()
                .title(title)
                .content(content)
                .deadLine(deadLine)
                .grade(grade)
                .build();
    }

}
