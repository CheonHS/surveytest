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
		return "/index";
	}
	@RequestMapping(value="/survey")
	public String survey(Survey survey, Model model) {
		model.addAttribute("s", survey);
		return "/survey";
	}
	
	@RequestMapping(value="/survey/New")
	public String surveyNew(Model model) {
		Survey survey = new Survey();
		survey = surveyService.surveyNew();
		model.addAttribute("s", survey);
		return "/survey";
	}
	

}
