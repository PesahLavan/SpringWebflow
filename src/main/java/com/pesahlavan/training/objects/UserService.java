package com.pesahlavan.training.objects;

import org.springframework.stereotype.Component;
import org.springframework.webflow.execution.RequestContext;

import java.util.ArrayList;

@Component
public class UserService {

	private ArrayList<User> userList = new ArrayList<>();

	public UserService() {
		userList.add(new User("user", "pass"));
	}

	public boolean userExist(User user, RequestContext context) {

//		System.out.println(context.getFlashScope().asMap());
//		System.out.println(context.getRequestScope().asMap());
//		System.out.println(context.getConversationScope().asMap());
//		System.out.println(context.getViewScope().asMap());
		System.out.println(context.getFlowScope().asMap());

		if (userList.contains(user)) {
			return true;
		} else {
			return false;
		}
	}

	public String createUser(User user) {
		if (usernameExist(user.getName())) {
			return "exist";
		} else {
			userList.add(user);
			return "success";
		}
	}

	private boolean usernameExist(String username){
		for (User user : userList) {
			if (user.getName().equals(username)){
				return true;
			}
		}

		return false;
	}
}

