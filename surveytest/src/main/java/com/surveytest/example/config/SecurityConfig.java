package com.surveytest.example.config;


import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.web.SecurityFilterChain;

import com.surveytest.example.mapper.SurveyMapper;
import com.surveytest.example.service.SurveyService;
import com.surveytest.example.service.SurveyServiceImpl;
import com.surveytest.example.service.UserService;
import com.surveytest.example.service.UserServiceImpl;

@Configuration
@EnableWebSecurity
@EnableGlobalMethodSecurity(prePostEnabled = true)
public class SecurityConfig{
	

	
//	@Bean
//	public UserService userService() {
//		return new UserServiceImpl();
//	}
//	
//	@Bean
//	public SurveyService surveyService() {
//		return new SurveyServiceImpl();
//	}
//	
//	@Bean
//	public SurveyMapper surveyMapper() {
//		return new SurveyMapper() {
//		};
//	}
	
	
	@Bean
	public SecurityFilterChain filterChain(HttpSecurity http) throws Exception{
		http
			.authorizeHttpRequests()
			.anyRequest().permitAll();
	
		return http.build();
		
	}

}
