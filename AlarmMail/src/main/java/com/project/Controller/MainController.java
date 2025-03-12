package com.project.Controller;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.project.entity.AlarmMailEntity;
import com.project.service.MemoService;

import lombok.RequiredArgsConstructor;

@Controller
@RequiredArgsConstructor
public class MainController {
	
	private final MemoService memoService;
	
	@GetMapping("/")
	public String Main(Model model) {
		List<AlarmMailEntity> memolist1 = memoService.getAllmemo1();
		List<AlarmMailEntity> memolist2 = memoService.getAllmemo2();
		model.addAttribute("memolist1",memolist1);
		model.addAttribute("memolist2",memolist2);
		return "index";
	}

}
