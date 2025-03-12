package com.project.entity;

import java.time.LocalDateTime;

import lombok.Data;

// メモEntity
@Data
public class AlarmMailEntity {
	
	private int Memo_No;
	private String Memo_Content;
	private LocalDateTime Memo_Time;
	private String Memo_OnOFF;
	private int Memo_Status;

}
