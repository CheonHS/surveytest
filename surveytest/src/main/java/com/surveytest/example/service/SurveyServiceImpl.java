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
		
		survey = surveyMapper.surveyRow(survey);
		survey.setQuestions(surveyMapper.listQuetion(survey));
		for(Question q : survey.getQuestions()) {
			q.setItems(surveyMapper.listItem(q));
		}
		return survey;	
	}
	
	//	Question ----------
	
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
	
	//	Item ----------
	
	//	옵션 추가
	@Override
	public void addItem(Question question) {
		surveyMapper.addItem(question);
	}
	
	//	옵션 삭제
	@Override
	public void delItem(Item item) {
		surveyMapper.delItem(item);
		
	}
	//	해당 질문 옵션 전체 삭제
	@Override
	public void delItemInQuestion(Question question) {
		surveyMapper.delItemInQuestion(question);
	}
	
	//	Update ----------
	
	@Override
	public void editSurvey(Survey survey) {
		surveyMapper.editSurvey(survey);
		if(!survey.getQuestions().isEmpty()) {
			surveyMapper.editQuestion(survey.getQuestions());
			for(Question q : survey.getQuestions()) {
				if(!q.getItems().isEmpty()) {
					surveyMapper.editItem(q.getItems());
				}
			}
		}	
	}

}
