package com.surveytest.example.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
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
	
	@RequestMapping(value="/survey")
	public String survey(@RequestParam("sId") String sId, Survey survey, Model model) {
		if(sId!=null && sId!="") {
			survey.setsId(Integer.parseInt(sId));
			survey = surveyService.surveyRow(survey);
		}
		model.addAttribute("s", survey);
		return "/survey";
	}
	
	@RequestMapping(value="/survey/delete")
	public String surveyDelete(Survey survey, Model model) {
		surveyService.surveyDelete(survey);
		return home(model);
	}
	
	@RequestMapping(value="/survey/edit")
	public String surveyEdit(Survey survey, Model model) {
		surveyService.surveyEdit(survey);
		survey = surveyService.surveyRow(survey);
		model.addAttribute("s", survey);
		return "/survey_ajax";
	}
	
	

}
