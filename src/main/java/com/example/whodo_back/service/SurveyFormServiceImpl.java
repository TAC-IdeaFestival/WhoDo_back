package com.example.whodo_back.service;

import com.example.whodo_back.domain.SurveyForm;
import com.example.whodo_back.dto.SurveyCreateRequestDto;
import com.example.whodo_back.repository.SurveyFormRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Service
@RequestMapping("/survey")
public class SurveyFormServiceImpl implements SurveyFormService {

    @Autowired
    private SurveyFormRepository surveyFormRepository;


    @Override
    public Long write(SurveyCreateRequestDto requestDto) {
        return surveyFormRepository.save(requestDto.toEntity()).getFormNum();
    }

    @Override
    public List<SurveyForm> formList(){
        return surveyFormRepository.findAll();
    }

    @Override
    public SurveyForm formView(Integer formNum) {
        return surveyFormRepository.findById(formNum).get();
    }

    @Override
    public void formDelete(Integer formNum) {
        surveyFormRepository.deleteById(formNum);
    }
}
