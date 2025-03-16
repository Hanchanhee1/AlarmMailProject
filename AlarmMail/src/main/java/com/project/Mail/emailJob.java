package com.project.Mail;

import org.springframework.scheduling.quartz.QuartzJobBean;

import java.util.List;

import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Component;
import com.project.mapper.MemoMapper;
import com.project.entity.memoEntity;

//メールサービス
@Component
public class emailJob extends QuartzJobBean {

    @Autowired
    private JavaMailSender mailSender;

    @Autowired
    private MemoMapper memoMapper;

    @Override
    protected void executeInternal(JobExecutionContext context) throws JobExecutionException {
    	// メール機能ON呼び出し
        List<memoEntity> memoList = memoMapper.emailSend();

        for (memoEntity memoEntity : memoList) {
            SimpleMailMessage message = new SimpleMailMessage();
            message.setTo("chan1hee22@gmail.com");	//　メール受信者
            message.setSubject("約束のアラームメールです。");	// メール題目
            message.setText("内容：" + memoEntity.getContent() + 
                            "\n\n日時：" + memoEntity.getReminder_Time());	// 約束内容 約束日時
            mailSender.send(message);
        }
    }
}
