package com.surveytest.example.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.surveytest.example.domain.Survey;

public interface SurveyService {

	public Survey surveyNew();

	public List<Survey> surveyList();

}
