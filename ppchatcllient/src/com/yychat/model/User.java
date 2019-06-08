package com.yychat.model;

import java.io.Serializable;

public class User  implements Serializable{

	private String userName;
	private String passName;
	private String userMessageType;

	public String getuserMessageType() {
		return userMessageType;
	}
	public void setuserMessageType(String userMessageType) {
		this.userMessageType = userMessageType;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getPassName() {
		return passName;
	}
	public void setPassName(String passName) {
		this.passName = passName;
	}
}