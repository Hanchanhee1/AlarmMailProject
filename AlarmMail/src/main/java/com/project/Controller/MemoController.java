package com.project.Controller;


import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.project.entity.AlarmMailEntity;
import com.project.service.MemoService;

import lombok.RequiredArgsConstructor;


@Controller
@RequiredArgsConstructor
public class MemoController {
	
	private final MemoService memoService;
	
	@GetMapping("/memoRead")
	public String Read(Model model, @RequestParam("Memo_No") int Memo_No) {
		AlarmMailEntity memoEntity = memoService.oneMemo(Memo_No);
		model.addAttribute("memoEntity",memoEntity);
		return "memo/memoRead";
	}
	
	@GetMapping("/memoWrite")
	public String Write() {
		return "memo/memoWrite";
	}
	
	@PostMapping("/memoWritePro")
	public String WritePro(@ModelAttribute AlarmMailEntity memoEntity) {
	    memoService.insertMemo(memoEntity);
	    return "redirect:/";
	}
	
	// 約束メモ変更画面
	@GetMapping("/memoUpdate")
	public String Update(Model model, @RequestParam("Memo_No") int Memo_No) {
		AlarmMailEntity memoEntity = memoService.oneMemo(Memo_No);
		model.addAttribute("memoEntity",memoEntity);
		return "memo/memoUpdate";
	}
	
	// 約束メモ変更
	@PostMapping("/memoUpdatePro")
	public String UpdatePro(AlarmMailEntity MemoEntity) {
		memoService.updateMemo(MemoEntity);
		return "redirect:/";
	}
	
	@PostMapping("/memoDelete")
	public String Delete(@RequestParam("Memo_No") int Memo_No) {
		memoService.deleteMemo(Memo_No);
		return "redirect:/";
	}


}
