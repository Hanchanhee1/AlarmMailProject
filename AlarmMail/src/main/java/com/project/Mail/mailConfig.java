package com.project.Mail;

import org.quartz.CronScheduleBuilder;
import org.quartz.JobBuilder;
import org.quartz.JobDetail;
import org.quartz.Scheduler;
import org.quartz.Trigger;
import org.quartz.TriggerBuilder;
import org.quartz.impl.StdSchedulerFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class mailConfig {
	
	@Bean
	public JobDetail sendEmailJobDetail() {
		return JobBuilder.newJob(emailJob.class)
						 .withIdentity("sendEmailJob") // Jobの名前設定
						 .storeDurably() // Schedulerに維持設定
						 .build();
	}
	
	@Bean
	public Trigger sendEmailTrigger() {
		
		// 毎日 00:00AMにメール送信 ("0 0 0 * * ?")　cron表現式
		// テスト ➝ "0/30 * * * * ?"
		CronScheduleBuilder scheduleBuilder = CronScheduleBuilder.cronSchedule("0 0 0 * * ?");
		
		return TriggerBuilder.newTrigger()
							 .forJob(sendEmailJobDetail()) // Job指定
							 .withIdentity("sendEmailTrigger") // Triggerの名前設定
							 .withSchedule(scheduleBuilder) // Triggerに設定
							 .build();
		
	}
	
	@Bean
	public JobDetail memoStatusJobDetail() {
		return JobBuilder.newJob(memoStatusJob.class)
						 .withIdentity("memoStatusJob")
						 .storeDurably()
						 .build();
	}

	@Bean
	public Trigger memoStatusTrigger() {
		
		// 一分毎回実行
		CronScheduleBuilder scheduleBuilder = CronScheduleBuilder.cronSchedule("0 * * * * ?");

		return TriggerBuilder.newTrigger()
							 .forJob(memoStatusJobDetail())
							 .withIdentity("memoStatusTrigger")
							 .withSchedule(scheduleBuilder)
							 .build();
	}

}
