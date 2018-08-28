package com.bmpl.testengine.common.dto;

import java.util.Date;

//This MessageDTO will act as and common message that will transfer throughout all the views
//Message will be common for all
public class MessageDTO {

	private String message;
	//To check the message status
	private int status;
	public int getStatus() {
		return status;
	}
	public void setStatus(int status) {
		this.status = status;
	}
	private Date date;
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	public Date getDate() {
		return date;
	}
	public void setDate(Date date) {
		this.date = date;
	}
	
}
