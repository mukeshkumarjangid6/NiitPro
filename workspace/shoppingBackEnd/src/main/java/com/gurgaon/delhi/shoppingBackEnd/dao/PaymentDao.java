package com.gurgaon.delhi.shoppingBackEnd.dao;

import com.gurgaon.delhi.shoppingBackEnd.dto.Payment;
import com.gurgaon.delhi.shoppingBackEnd.dto.User;

public interface PaymentDao {
	public Payment getPaymentDetails(User user);
	public boolean add(Payment payment);
}