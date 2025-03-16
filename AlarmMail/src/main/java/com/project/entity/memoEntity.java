package com.project.entity;

import java.time.LocalDateTime;

import lombok.Data;

// メモEntity
@Data
public class memoEntity {
	
	private int memo_Id;
	private String content;
	private LocalDateTime reminder_Time;
	private String alarm_Status;
	private int memo_Status;

}
