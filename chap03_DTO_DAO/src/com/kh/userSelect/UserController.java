package com.kh.userSelect;

import java.sql.Connection;
import java.util.List;

public class UserController {
	private UserModel model;
	private UserView view;
	
	public UserController(Connection con, UserView view) {
		this.model = new UserModel(con);
		this.view = view;
	}
	public void displayUser() {
		List<UserDTO> userDto = model.getUser();
		view.displayCafes(userDto);
	}
}
