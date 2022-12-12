package com.surveytest.example.service;

import java.util.List;

import com.surveytest.example.domain.Survey;

public interface SurveyService {

	public void surveyWrite(Survey survey);

	public List<Survey> surveyList();

	public void surveyDelete(Survey survey);

}
