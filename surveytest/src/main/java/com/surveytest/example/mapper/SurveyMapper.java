package com.surveytest.example.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.surveytest.example.domain.Item;
import com.surveytest.example.domain.Question;
import com.surveytest.example.domain.Survey;

@Mapper
public interface SurveyMapper {

	//	Survey ----------
	
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

	//	Item ----------
	
	//	옵션 목록
	public List<Item> listItem(Question question);
	
	//	옵션 추가
	public void addItem(Question question);
	
	//	옵션 삭제
	public void delItem(Item item);

	//	해당 질문 옵션 전체 삭제
	public void delItemInQuestion(Question question);

	//	Update ----------
	
	//	설문 수정
	public void editSurvey(Survey survey);

	//	질문 수정
	public void editQuestion(List<Question> questions);

	//	옵션 수정
	public void editItem(List<Item> items);

}
