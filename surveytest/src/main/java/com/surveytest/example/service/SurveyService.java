package com.surveytest.example.service;

import java.util.List;

import com.surveytest.example.domain.Question;
import com.surveytest.example.domain.Survey;

public interface SurveyService {

	//	설문 작성
	public void surveyWrite(Survey survey);
	
	//	설문 목록
	public List<Survey> surveyList();

	//	설문 상세
	public Survey surveyRow(Survey survey);
	
	//	Question ----------
	
	//	질문 추가
	public void addQuestion(Survey survey);
	
	//	질문 목록	
	public List<Question> listQuetion(Survey survey);

	//	질문 삭제
	public void delQuestion(Question question);


}
