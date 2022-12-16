package com.surveytest.example.service;

import java.util.List;

import com.surveytest.example.domain.Question;
import com.surveytest.example.domain.Survey;

public interface SurveyService {

	public void surveyWrite(Survey survey);

	public List<Survey> surveyList();

	public void surveyDelete(Survey survey);

	public Survey surveyRow(Survey survey);

	public void surveyEdit(Survey survey);

	public void addQuestion(Survey survey);

	public List<Question> listQuestion(Survey survey);

}
