package com.surveytest.example.controller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import com.surveytest.example.domain.Item;
import com.surveytest.example.domain.Question;
import com.surveytest.example.domain.Survey;
import com.surveytest.example.service.SurveyService;

@Controller
@RequestMapping(value="/survey")
public class SurveyController {
	
	@Autowired
	SurveyService surveyService;
	
	//	첫 화면
	@RequestMapping(value="/list")
	public String home(Model model) {
		List<Survey> list = surveyService.surveyList();
		model.addAttribute("list", list);
		return "/survey/list";
	}
	
	//	설문지
	@RequestMapping(value="/form")
	public String survey(Survey survey, Model model) {
		survey = surveyService.surveyRow(survey);	

		model.addAttribute("s", survey);
		return "/survey/survey";
	}
	
	//	설문 작성
	@RequestMapping(value="/write")
	public String surveyWrite(RedirectAttributes redirect, Survey survey, Model model) {
		surveyService.surveyWrite(survey);
		redirect.addAttribute("sId", survey.getsId());
		return "redirect:/survey/form";
	}
	
	//	설문지 Ajax
	@RequestMapping(value="/Ajax")
	public String surveyAjax(Survey survey, Model model) {
		survey = surveyService.surveyRow(survey);	
		
		model.addAttribute("s", survey);
		return "/survey/survey_ajax";
	}
	
	
	//	Question ----------
	
	//	질문 추가
	@RequestMapping(value="/qAdd")
	public String qAdd(Survey survey, Model model) {
		surveyService.addQuestion(survey);
		return surveyAjax(survey, model);
	}
	
	//	질문 삭제
	@RequestMapping(value="/qDel")
	public String qDel(Survey survey, Question question, Model model) {
		surveyService.delItemInQuestion(question);
		surveyService.delQuestion(question);
		return surveyAjax(survey, model);
	}
	
	//	Question ----------
	
	//	옵션 추가
	@RequestMapping(value="/iAdd")
	public String iAdd(Survey survey, Question question, Model model) {
		surveyService.addItem(question);
		return surveyAjax(survey, model);
	}
	
	//	옵션 삭제
	@RequestMapping(value="/iDel")
	public String iAdd(Survey survey, Item item, Model model) {
		surveyService.delItem(item);
		return surveyAjax(survey, model);
	}
	
	//	Update ----------
	
	//	JSON Update
	@RequestMapping(value="/jsonUpdate")
	public String response(@RequestBody Survey survey, Model model) {
		surveyService.editSurvey(survey);

		model.addAttribute("s", survey);
		return "/survey/survey_ajax";
	}
	
}
