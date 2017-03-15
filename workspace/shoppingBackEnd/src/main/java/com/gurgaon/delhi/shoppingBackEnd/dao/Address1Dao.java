package com.gurgaon.delhi.shoppingBackEnd.dao;

import java.util.List;

import com.gurgaon.delhi.shoppingBackEnd.dto.Address1;

public interface Address1Dao {

	public List<Address1> Address1List(int user_id);

	boolean add(Address1 address1);

	boolean update(Address1 address1);

	boolean delete(int address_id, int user_id);
}