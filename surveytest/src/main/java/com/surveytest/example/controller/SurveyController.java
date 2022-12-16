package com.surveytest.example.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.surveytest.example.domain.Survey;
import com.surveytest.example.service.SurveyService;

@Controller
public class SurveyController {
	
	@Autowired
	SurveyService surveyService;
	
	@RequestMapping(value="/")
	public String home(Model model) {
		List<Survey> list = surveyService.surveyList();
		model.addAttribute("list", list);
		return "/list";
	}
	@RequestMapping(value="/survey/write")
	public String surveyWrite(RedirectAttributes redirect, Survey survey, Model model) {
		surveyService.surveyWrite(survey);
		redirect.addAttribute("sId", survey.getsId());
		return "redirect:/survey";
	}
	
	@ResponseBody
	@RequestMapping(value="/survey")
	public String survey(@RequestBody Survey survey, Model model) {
		survey = surveyService.surveyRow(survey);
		survey.setQuestions(surveyService.listQuestion(survey));
		model.addAttribute("s", survey);
		model.addAttribute("q", survey.getQuestions());
		return "/survey";
	}
	
	@RequestMapping(value="/survey/surveyAjax")
	public String surveyAjax(Survey survey, Model model) {
		survey = surveyService.surveyRow(survey);
		model.addAttribute("s", survey);
		return "/survey_ajax";
	}
	
	@RequestMapping(value="/survey/delete")
	public String surveyDelete(Survey survey, Model model) {
		surveyService.surveyDelete(survey);
		return home(model);
	}
	
	@RequestMapping(value="/survey/edit")
	public String surveyEdit(Survey survey, Model model) {
		surveyService.surveyEdit(survey);
		return surveyAjax(survey, model);
	}
	
	@RequestMapping(value="/survey/addQuestion")
	public String addQuestion(Survey survey, Model model) {
		surveyService.addQuestion(survey);
		return surveyAjax(survey, model);
	}
	
	

}
