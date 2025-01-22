package com.hcl.entity;

import java.time.LocalDate;

public class UserMessage {

	private int id;
	private LocalDate msgDate;
	private String msg;
	private String userName;
	private String userEmail;
	public UserMessage() {
		
	}
	public UserMessage(int id, LocalDate msgDate, String msg, String userName, String userEmail) {
		super();
		this.id = id;
		this.msgDate = msgDate;
		this.msg = msg;
		this.userName = userName;
		this.userEmail = userEmail;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public LocalDate getMsgDate() {
		return msgDate;
	}
	public void setMsgDate(LocalDate msgDate) {
		this.msgDate = msgDate;
	}
	public String getMsg() {
		return msg;
	}
	public void setMsg(String msg) {
		this.msg = msg;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getUserEmail() {
		return userEmail;
	}
	public void setUserEmail(String userEmail) {
		this.userEmail = userEmail;
	}

}
