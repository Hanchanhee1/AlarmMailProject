package com.project.Mail;

import org.quartz.Job;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.project.service.memoService;

// メモ状態変更メソッド
@Component
public class memoStatusJob implements Job {
	
	@Autowired
	private memoService memoService;

	@Override
	public void execute(JobExecutionContext context) throws JobExecutionException {
		memoService.updateMemoStatus();
	}

}
