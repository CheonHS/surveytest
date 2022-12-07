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
	public Survey surveyNew() {
		return surveyMapper.surveyNew();
	}

	@Override
	public List<Survey> surveyList() {
		return surveyMapper.surveyList();
	}

}
