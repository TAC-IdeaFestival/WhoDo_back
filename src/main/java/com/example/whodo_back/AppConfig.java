package com.example.whodo_back;

import com.example.whodo_back.repository.MemberRepository;
import com.example.whodo_back.repository.MemberRepositoryImpl;
import com.example.whodo_back.repository.SurveyFormRepository;
import com.example.whodo_back.service.MemberService;
import com.example.whodo_back.service.MemberServiceImpl;
import com.example.whodo_back.service.SurveyFormService;
import com.example.whodo_back.service.SurveyFormServiceImpl;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class AppConfig {

    @Bean
    public MemberService memberService(){
        return new MemberServiceImpl(memberRepository());
    }

    @Bean
    public MemberRepository memberRepository() {
        return new MemberRepositoryImpl();
    }

    @Bean
    public SurveyFormService surveyFormService() { return new SurveyFormServiceImpl(); }

}
