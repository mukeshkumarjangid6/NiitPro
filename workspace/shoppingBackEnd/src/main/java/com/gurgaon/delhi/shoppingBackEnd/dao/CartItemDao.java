package com.gurgaon.delhi.shoppingBackEnd.dao;

import java.util.List;
import com.gurgaon.delhi.shoppingBackEnd.dto.Cart;
import com.gurgaon.delhi.shoppingBackEnd.dto.CartItem;
import com.gurgaon.delhi.shoppingBackEnd.dto.Product;
import com.gurgaon.delhi.shoppingBackEnd.dto.User;

public interface CartItemDao {

	public boolean addCartItem(CartItem cartItem);

	public List<CartItem> cartItemGetByCart(Cart cart);

	public boolean updateCartItem(CartItem cartItem);

	public boolean deleteCartItem(int cartItem_Id);

	public CartItem getCartItemByCartItem_Id(int cartItem_Id);

	public CartItem getCartItemByUserIdAndProductId(Cart cart, Product product);
	
	public boolean searchCartItemByUserIdAndProductId(Cart cart, Product product);
}