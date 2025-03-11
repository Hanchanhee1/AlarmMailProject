package com.project.entity;

import java.time.LocalDateTime;

import lombok.Data;

// メモEntity
@Data
public class AlarmMailEntity {
	
	private int memono;
	private String memocontent;
	private LocalDateTime time;
	private String onoff;

}
