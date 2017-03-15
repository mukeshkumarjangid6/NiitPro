package com.gurgaon.delhi.shoppingBackEnd.dao;

import com.gurgaon.delhi.shoppingBackEnd.dto.Cart;

public interface CartDao {
public boolean updateCart(Cart cart);
public Cart getCartBycart_Id(int cart_Id);
}