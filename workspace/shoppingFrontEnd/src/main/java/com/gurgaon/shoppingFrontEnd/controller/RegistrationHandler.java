package com.gurgaon.shoppingFrontEnd.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.binding.message.MessageBuilder;
import org.springframework.binding.message.MessageContext;
import org.springframework.stereotype.Component;

import com.gurgaon.delhi.shoppingBackEnd.dao.UserDao;
import com.gurgaon.delhi.shoppingBackEnd.dto.User;

@Component
public class RegistrationHandler {
	@Autowired
	UserDao userDao;

	public User initFlow() {
		return new User();
	}

	public String saveUser(User user) {
		boolean status = userDao.add(user);
		if (status) {
			return "success";
		} else {
			return "failure";
		}
	}

	public String validateDetails(User user, MessageContext messageContext) {
		String status = "success";
		if (user.getName().isEmpty()) {
			messageContext.addMessage(
					new MessageBuilder().error().source("name").defaultText("name cannot be Empty").build());
			status = "failure";
		}
		if (user.getEmail().isEmpty()) {
			messageContext.addMessage(
					new MessageBuilder().error().source("email").defaultText("Email cannot be Empty").build());
			status = "failure";
		}
		if (user.getPassword() == null) {
			messageContext.addMessage(
					new MessageBuilder().error().source("password").defaultText("Password cannot be Empty").build());
			status = "failure";
		}

		if (user.getContact() == null) {
			messageContext.addMessage(
					new MessageBuilder().error().source("contact").defaultText("Contact cannot be Empty").build());
			status = "failure";
		}
		if (user.getRole() == null) {
			messageContext.addMessage(
					new MessageBuilder().error().source("role").defaultText("Role cannot be Empty").build());
			status = "failure";
		}
		if (user.getEnabled() == false) {
			messageContext.addMessage(
					new MessageBuilder().error().source("enabled").defaultText("Enabled cannot be Empty").build());
			status = "failure";
		}
		return status;
	}
}