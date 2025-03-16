package com.project.controller;


import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.project.entity.memoEntity;
import com.project.service.memoService;

import lombok.RequiredArgsConstructor;

@Controller
@RequiredArgsConstructor
public class mainController {
	
	private final memoService memoService;
	
	//　Main画面
	@GetMapping("/")
	public String Main(Model model) {
		List<memoEntity> memoList = memoService.memoSelectAll();
		List<memoEntity> completList = memoService.completSelectAll();
		model.addAttribute("memoList",memoList);
		model.addAttribute("completList",completList);
		return "index";
	}

}
