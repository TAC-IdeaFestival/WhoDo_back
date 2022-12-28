package com.example.whodo_back.domain.servey.entity;

import lombok.*;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
@Data
@Builder
@Getter
@Setter
@Table(name = "survey_form_tbl")
@AllArgsConstructor
@NoArgsConstructor
public class SurveyForm {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long formNum;

    @Column(nullable = false)
    private String title;

    private String content;

    private LocalDate deadLine;

    private String grade;
}
