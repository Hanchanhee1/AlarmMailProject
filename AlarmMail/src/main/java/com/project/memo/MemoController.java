package com.project.memo;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class MemoController {
	
	@GetMapping("/memo")
	public String Read() {
		return "memo/memoRead";
	}
	
	@GetMapping("/memoWrite")
	public String Write() {
		return "memo/memoWrite";
	}
	
	@PostMapping("/memoWritePro")
	public String WritePro() {
		return "redirect:/";
	}
	
	@GetMapping("/memoUpdate")
	public String Update() {
		return "memo/memoUpdate";
	}
	
	@PostMapping("/memoUpdatePro")
	public String UpdatePro() {
		return "redirect:/";
	}
	
	@PostMapping("/memoDelete")
	public String Delete() {
		return "redirect:/";
	}


}
