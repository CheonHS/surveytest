package com.surveytest.example.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.surveytest.example.domain.Item;
import com.surveytest.example.domain.Question;
import com.surveytest.example.domain.Survey;
import com.surveytest.example.mapper.SurveyMapper;

@Service
public class SurveyServiceImpl implements SurveyService {

	@Autowired
	SurveyMapper surveyMapper;
	
	//	설문 작성
	@Override
	public void surveyWrite(Survey survey) {
		surveyMapper.surveyWrite(survey);
	}
	//	설문 목록
	@Override
	public List<Survey> surveyList() {
		return surveyMapper.surveyList();
	}
	//	설문 상세
	@Override
	public Survey surveyRow(Survey survey) {
		return surveyMapper.surveyRow(survey);
		
	}
	
	//	Question ----------
	
	//	질문 목록
	@Override
	public List<Question> listQuetion(Survey survey) {
		return surveyMapper.listQuetion(survey);
	}
	
	//	질문 추가
	@Override
	public void addQuestion(Survey survey) {
		surveyMapper.addQuestion(survey);
		
	}
	//	질문 삭제
	@Override
	public void delQuestion(Question question) {
		surveyMapper.delQuestion(question);
		
	}
	
	//	옵션 목록
	@Override
	public List<Item> listItem(Question question) {
		return surveyMapper.listItem(question);
	}
	@Override
	public void addItem(Question question) {
		surveyMapper.addItem(question);
		
	}
	@Override
	public void delItem(Item item) {
		surveyMapper.delItem(item);
		
	}

}
