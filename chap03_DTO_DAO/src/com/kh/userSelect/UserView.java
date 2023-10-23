package com.kh.userSelect;

import java.util.List;


public class UserView {
	public void displayCafes(List<UserDTO> cafes) {
		for(UserDTO c : cafes) {
			System.out.println("User Id : " + c.getUser_id()
			+ "\nUser Name : " + c.getUsername()
			+ "\nUser Email : " + c.getEmail()
			+ "\nUser Date : " + c.getReg_date());
			
		}
	}
}
