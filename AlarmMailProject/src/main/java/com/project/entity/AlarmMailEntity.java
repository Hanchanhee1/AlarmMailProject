package com.project.entity;

import java.util.Date;

import lombok.Data;

@Data
public class AlarmMailEntity {
	
	private int memono;
	private String memocontent;
	private Date time;
	private String onoff;

}
