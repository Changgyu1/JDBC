package com.kh.userSelect;

import java.util.Date;

public class UserDTO {
	private int user_id;
	private String username;
	private String email;
	private Date reg_date;

	// 생성자
	// 1. 기본 생성자
	public UserDTO() {
	}

	// 2. 파라미터 값을 받을 생성자
	public UserDTO(int user_id, String username, String email, Date reg_date) {
		this.user_id = user_id;
		this.username = username;
		this.email = email;
		this.reg_date = reg_date;
	}

	public int getUser_id() {
		return user_id;
	}

	public void setUser_id(int user_id) {
		this.user_id = user_id;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public Date getReg_date() {
		return reg_date;
	}

	public void setReg_date(Date reg_date) {
		this.reg_date = reg_date;
	}
}