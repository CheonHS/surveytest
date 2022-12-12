package com.surveytest.example.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
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
	public String surveyWrite(Survey survey, Model model) {
		int sId = survey.getsId();
		if(sId<=0) {
			surveyService.surveyWrite(survey);
		}
		model.addAttribute("s", survey);
		return "/survey";
	}
	
	@RequestMapping(value="/survey")
	public String survey(Survey survey, Model model) {
		model.addAttribute("s", survey);
		return "/survey";
	}
	
	@RequestMapping(value="/survey/delete")
	public String surveyDelete(Survey survey, Model model) {
		surveyService.surveyDelete(survey);
		return home(model);
	}
	
	

}
