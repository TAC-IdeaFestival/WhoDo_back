package com.example.whodo_back.controller;

import com.example.whodo_back.Response.ResponseService;
import com.example.whodo_back.dto.SurveyCreateRequestDto;
import com.example.whodo_back.service.SurveyFormService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
public class SurveyFormController {

    private SurveyFormService surveyFormService;
    private ResponseService responseService;

    // 리스트
    @GetMapping(value = "survey/list")
    public ResponseEntity.BodyBuilder getSurveyList(){
        responseService.getListResponse(surveyFormService.formList());
        return ResponseEntity.status(HttpStatus.OK);
    }
    // 상세보기
    @GetMapping(value = "survey/{formNum}")
    public ResponseEntity.BodyBuilder getSurvey(@PathVariable int formNum){
        responseService.getSurveyResponse(surveyFormService.formView(formNum));
        return ResponseEntity.status(HttpStatus.OK);
    }

    // 등록하기
    @PostMapping(value = "survey/write")
    public ResponseEntity.BodyBuilder create(@RequestBody SurveyCreateRequestDto requestDto){
        surveyFormService.write(requestDto);
        return ResponseEntity.status(HttpStatus.CREATED);
    }
    // 삭제하기
    @DeleteMapping(value = "survey/{formNum}")
    public ResponseEntity.BodyBuilder delete(@PathVariable int formNum){
        surveyFormService.formDelete(formNum);
        return ResponseEntity.status(HttpStatus.NO_CONTENT);
    }
}
