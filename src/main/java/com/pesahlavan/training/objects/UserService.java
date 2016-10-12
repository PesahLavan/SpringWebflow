package com.pesahlavan.training.objects;

import org.springframework.stereotype.Component;

import java.util.ArrayList;

@Component
public class UserService {

	private ArrayList<User> userList = new ArrayList<>();
	public String checkUser(User user) {

		for (User existingUser : userList) {
			if (existingUser.equals(user)){
				return "success";
			}
		}
		return "failed";
	}
	public  void createUser(User user){
		userList.add(user);
	}
}

