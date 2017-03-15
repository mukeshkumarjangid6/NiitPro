package com.gurgaon.delhi.shoppingBackEnd.dao;

import com.gurgaon.delhi.shoppingBackEnd.dto.User;

public interface UserDao {
	public User getUserByUsername(String email);
	boolean add(User user);
	boolean update(User user);
	boolean delete(String email);
	public User getUserById(int user_id);
}