package com.example.whodo_back.domain.servey.repository;

import com.example.whodo_back.domain.servey.entity.SurveyForm;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SurveyFormRepository extends JpaRepository<SurveyForm, Integer> {
}
