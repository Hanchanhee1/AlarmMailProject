package com.project.controller;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class MainController {
	
	@GetMapping("/")
	public String Main() {
		return "index";
	}
	
	@GetMapping("/memoWrite")
	public String Write() {
		return "memoWrite/memoWrite";
	}

}
