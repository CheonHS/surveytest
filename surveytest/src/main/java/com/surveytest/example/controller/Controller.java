package com.surveytest.example.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.surveytest.example.service.SurveyService;

@org.springframework.stereotype.Controller
public class Controller {

	private final Logger logger = LoggerFactory.getLogger(this.getClass());
	
	
//	@Autowired SurveyService surveyservice;
	
	@RequestMapping("/")
	public String surveyList(Model model) {
		logger.debug("debug");
		logger.info("info");
		logger.error("error");
		return "/surveyList";	
	}
}
