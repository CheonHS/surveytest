package com.surveytest.example.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.surveytest.example.domain.Question;
import com.surveytest.example.domain.Survey;
import com.surveytest.example.service.SurveyService;

@Controller
public class SurveyController {
	
	@Autowired
	SurveyService surveyService;
	
	//	첫 화면
	@RequestMapping(value="/")
	public String home(Model model) {
		List<Survey> list = surveyService.surveyList();
		model.addAttribute("list", list);
		return "/list";
	}
	
	//	설문지
	@RequestMapping(value="/survey")
	public String survey(Survey survey, Model model) {
//		survey = surveyService.surveyRow(survey);
//		survey.setQuestions(surveyService.listQuetion(survey));
//		
//		model.addAttribute("s", survey);
//		model.addAttribute("q", survey.getQuestions());
		
		Survey s = new Survey();
		s = surveyService.surveyRow(survey);
		s.setQuestions(surveyService.listQuetion(s));
		
		model.addAttribute("s", s);
		model.addAttribute("q", s.getQuestions());
		
		return "/survey";
	}
	
	//	설문 작성
	@RequestMapping(value="/survey/write")
	public String surveyWrite(RedirectAttributes redirect, Survey survey, Model model) {
		surveyService.surveyWrite(survey);
		redirect.addAttribute("sId", survey.getsId());
		return "redirect:/survey";
	}
	
	//	설문지 Ajax
	@RequestMapping(value="/survey/Ajax")
	public String surveyAjax(Survey survey, Model model) {
		survey = surveyService.surveyRow(survey);
		survey.setQuestions(surveyService.listQuetion(survey));
		
		model.addAttribute("s", survey);
		model.addAttribute("q", survey.getQuestions());
		return "/survey_ajax";
	}
	
	
	//	Question ----------
	
	//	질문 추가
	@RequestMapping(value="/survey/qAdd")
	public String qAdd(Survey survey, Model model) {
		surveyService.addQuestion(survey);
		return surveyAjax(survey, model);
	}
	
	@RequestMapping(value="/survey/qDel")
	public String qDel(Survey survey, Question question, Model model) {
		surveyService.delQuestion(question);
		return surveyAjax(survey, model);
	}
	
	//	Respone ----------
	
	@ResponseBody
	@PostMapping(value="/survey/json" )
	public String response(@RequestBody Survey survey, Model model) {
		model.addAttribute("s", survey);
		return "/json";
	}
	
	

}
