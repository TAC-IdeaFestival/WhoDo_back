package com.example.whodo_back.domain.servey.service;

import com.example.whodo_back.domain.servey.entity.SurveyForm;
import com.example.whodo_back.domain.servey.dto.SurveyCreateRequestDto;
import com.example.whodo_back.domain.servey.repository.SurveyFormRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Service
@RequestMapping("/survey")
@RequiredArgsConstructor
public class SurveyFormServiceImpl implements SurveyFormService {

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
