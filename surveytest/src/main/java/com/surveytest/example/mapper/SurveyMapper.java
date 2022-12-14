package com.surveytest.example.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.surveytest.example.domain.Survey;
import com.surveytest.example.domain.Survey.Question;

@Mapper
public interface SurveyMapper {

	public void surveyWrite(Survey survey);

	public List<Survey> surveyList();

	public void surveyDelete(Survey survey);

	public Survey surveyRow(Survey survey);

	public void surveyEdit(Survey survey);

	public void addQuestion(Survey survey);

	public List<Question> listQuestion(Survey survey);

}
