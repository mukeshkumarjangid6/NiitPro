package com.gurgaon.shoppingFrontEnd.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.binding.message.MessageBuilder;
import org.springframework.binding.message.MessageContext;
import org.springframework.stereotype.Component;

import com.gurgaon.delhi.shoppingBackEnd.dao.CartDao;
import com.gurgaon.delhi.shoppingBackEnd.dao.UserDao;
import com.gurgaon.delhi.shoppingBackEnd.dto.Cart;
import com.gurgaon.delhi.shoppingBackEnd.dto.Payment;
import com.gurgaon.delhi.shoppingBackEnd.dto.User;

@Component
public class CheckoutHandler {

	@Autowired
	UserDao userDao;

	@Autowired
	CartDao cartDao;

	public User initCart(int user_id) {
		/*
		 * cart = user.getCart(); System.out.println("Cart grand total : " +
		 * cart.getGrandTotal());
		 */
		return userDao.getUserById(user_id);
	}

	public Cart initCartByUser(int user_id) {
		User user = userDao.getUserById(user_id);
		return user.getCart();
	}

	public Payment initPaymentByUserid(int user_id) {
		User user = userDao.getUserById(user_id);
		Payment payment = new Payment();
		payment.setUser(user);
		return payment;
	}

	public boolean emptyCart(Cart cart) {
		cart.setGrandTotal(0);
		cart.setCartItemCount(0);
		try {
			cartDao.updateCart(cart);
			cartDao.deleteAllCartItems(cart);
			return true;
		} catch (Exception ex) {
			return false;
		}
	}

	public String saveDetails(User user) {
		boolean status2 = emptyCart(user.getCart());
		// boolean status1 = userDao.update(user);

		if (status2) {
			return "success";
		} else {
			return "failure";
		}
	}

	// only for address
	public String addressValidateDetails(User user, MessageContext messageContext) {
		String status = "success";

		if (user.getAddress().isEmpty()) {
			messageContext.addMessage(
					new MessageBuilder().error().source("address").defaultText("address cannot be Empty").build());
			status = "failure";
		}

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

	public String paymentValidateDetails(Payment payment, MessageContext messageContext) {
		String status = "success";
		if (payment.getCardno().isEmpty()) {
			messageContext.addMessage(
					new MessageBuilder().error().source("cardno").defaultText("card no cannot be Empty").build());
			status = "failure";
		}
		if (payment.getCardName().isEmpty()) {
			messageContext.addMessage(new MessageBuilder().error().source("cardName")
					.defaultText("Card on Name cannot be Empty").build());
			status = "failure";
		}
		if (payment.getMm() == 0) {
			messageContext.addMessage(
					new MessageBuilder().error().source("mm").defaultText("Expire month cannot be Empty").build());
			status = "failure";
		}
		if (payment.getYy() == 0) {
			messageContext.addMessage(
					new MessageBuilder().error().source("yy").defaultText("Expire year cannot be Empty").build());
			status = "failure";
		}
		return status;
	}
}