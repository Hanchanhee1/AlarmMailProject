package com.project.controller;


import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.project.entity.memoEntity;
import com.project.service.memoService;

import lombok.RequiredArgsConstructor;


@Controller
@RequiredArgsConstructor
public class memoController {
	
	private final memoService memoService;
	
	// 約束メモ詳細画面
	@GetMapping("/memoRead")
	public String Read(Model model, @RequestParam("memo_Id") int memo_Id) {
		memoEntity memoEntity = memoService.memoOneSelect(memo_Id);
		model.addAttribute("memoEntity",memoEntity);
		return "memo/memoRead";
	}
	
	// 約束メモ登録画面
	@GetMapping("/memoWrite")
	public String Write() {
		return "memo/memoWrite";
	}
	
	// 約束メモ登録
	@PostMapping("/memoWritePro")
	public String WritePro(@ModelAttribute memoEntity memoEntity) {
	    memoService.memoInsert(memoEntity);
	    return "redirect:/";
	}
	
	// 約束メモ変更画面
	@GetMapping("/memoUpdate")
	public String memoUpdate(Model model, @RequestParam("memo_Id") int memo_Id) {
		memoEntity memoEntity = memoService.memoOneSelect(memo_Id);
		model.addAttribute("memoEntity",memoEntity);
		return "memo/memoUpdate";
	}
	
	// 約束メモ変更
	@PostMapping("/memoUpdatePro")
	public String memoUpdatePro(memoEntity MemoEntity) {
		memoService.memoUpdate(MemoEntity);
		return "redirect:/";
	}
	
	// 約束メモ削除
	@PostMapping("/memoDelete")
	public String memoDelete(@RequestParam("memo_Id") int memo_Id) {
		memoService.memoDelete(memo_Id);
		return "redirect:/";
	}


}
