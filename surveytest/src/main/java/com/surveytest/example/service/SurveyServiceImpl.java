package com.surveytest.example.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.surveytest.example.domain.Survey;
import com.surveytest.example.mapper.SurveyMapper;

@Service
public class SurveyServiceImpl implements SurveyService {

	@Autowired
	SurveyMapper surveyMapper;
	
	@Override
	public void surveyWrite(Survey survey) {
		surveyMapper.surveyWrite(survey);
	}

	@Override
	public List<Survey> surveyList() {
		return surveyMapper.surveyList();
	}

	@Override
	public void surveyDelete(Survey survey) {
		surveyMapper.surveyDelete(survey);
		
	}

	@Override
	public Survey surveyRow(Survey survey) {
		return surveyMapper.surveyRow(survey);
		
	}

	@Override
	public void surveyEdit(Survey survey) {
		surveyMapper.surveyEdit(survey);
		
	}

}
