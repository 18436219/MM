package com.yychat.model;

import java.io.Serializable;

public class user  implements Serializable{

	private String userName;
	private String passName;
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
