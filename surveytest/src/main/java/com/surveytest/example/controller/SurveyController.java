package com.surveytest.example.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class SurveyController {

	@RequestMapping(value="/")
	public String surveyList(Model model) {

		return "/surveyList";
	}

}
