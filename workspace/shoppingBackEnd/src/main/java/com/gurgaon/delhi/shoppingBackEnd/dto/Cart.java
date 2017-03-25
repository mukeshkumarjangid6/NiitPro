package com.gurgaon.delhi.shoppingBackEnd.dto;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

import com.fasterxml.jackson.annotation.JsonBackReference;

@Entity
public class Cart implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int cart_Id;

	private int cartItemCount;

	private int grandTotal;

	@OneToOne(cascade = CascadeType.PERSIST)
	@JoinColumn(name = "user_id")
	private User user;

	@JsonBackReference
	@OneToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL, mappedBy = "cart")
	private List<CartItem> cartList = new ArrayList<CartItem>(0);
	
	// setter getter 
	public int getCart_Id() {
		return cart_Id;
	}

	public void setCart_Id(int cart_Id) {
		this.cart_Id = cart_Id;
	}

	public int getCartItemCount() {
		return cartItemCount;
	}

	public void setCartItemCount(int cartItemCount) {
		this.cartItemCount = cartItemCount;
	}

	public int getGrandTotal() {
		return grandTotal;
	}

	public void setGrandTotal(int grandTotal) {
		this.grandTotal = grandTotal;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public List<CartItem> getCartList() {
		return cartList;
	}

	public void setCartList(List<CartItem> cartList) {
		this.cartList = cartList;
	}

	@Override
	public String toString() {
		return "Cart [cart_Id=" + cart_Id + ", cartItemCount=" + cartItemCount + ", grandTotal=" + grandTotal
				+ ", user=" + user + ", cartList=" + cartList + "]";
	}

}