package com.surveytest.example.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.surveytest.example.domain.Question;
import com.surveytest.example.domain.Survey;

@Mapper
public interface SurveyMapper {

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
