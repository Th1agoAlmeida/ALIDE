package com.upe.alide.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class QuizController {
	
	@RequestMapping(value = {"/quiz.html", "/quiz"}, method = RequestMethod.GET)
	public String quiz() {
		
		return "../static/quiz.html";
	}
	
}
