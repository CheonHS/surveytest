package com.surveytest.example.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.surveytest.example.domain.Survey;

@Mapper
public interface SurveyMapper {

	public void surveyWrite(Survey survey);

	public List<Survey> surveyList();

	public void surveyDelete(Survey survey);

	public Survey surveyRow(Survey survey);

	public void surveyEdit(Survey survey);

}
