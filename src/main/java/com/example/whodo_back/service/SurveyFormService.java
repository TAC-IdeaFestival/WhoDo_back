package com.example.whodo_back.service;

import com.example.whodo_back.domain.SurveyForm;
import com.example.whodo_back.dto.SurveyCreateRequestDto;

import java.util.List;


public interface SurveyFormService {
    // 생성
    Long write(SurveyCreateRequestDto requestDto);

    //리스트
    List<SurveyForm> formList();

    //상세보기
    SurveyForm formView(Integer formNum);

    // 삭제
    void formDelete(Integer formNum);
}