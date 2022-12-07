package com.surveytest.example.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.surveytest.example.domain.Survey;

@Mapper
public interface SurveyMapper {

	public Survey surveyNew();

	public List<Survey> surveyList();

}
