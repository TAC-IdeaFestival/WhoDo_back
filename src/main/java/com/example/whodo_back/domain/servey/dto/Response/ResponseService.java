package com.example.whodo_back.domain.servey.dto.Response;

import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ResponseService {

    public<T> SurveyFormResponse<T> getSurveyResponse(T data){
        SurveyFormResponse surveyFormResponse=new SurveyFormResponse();
        surveyFormResponse.surveyData=data;
        setSuccessResponse(surveyFormResponse);

        return surveyFormResponse;
    }

    public<T> SurveyFormListResponse<T> getListResponse(List<T> dataList){
        SurveyFormListResponse surveyFormListResponse = new SurveyFormListResponse();
        surveyFormListResponse.surveyDataList=dataList;
        setSuccessResponse(surveyFormListResponse);

        return surveyFormListResponse;
    }

    void setSuccessResponse(CommonResponse response){
        response.code=0;
        response.success=true;
        response.message="SUCCESS";
    }
}
