package com.gurgaon.delhi.shoppingBackEnd.dto;

import java.io.Serializable;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;

import org.hibernate.validator.constraints.NotBlank;

@Entity
public class User implements Serializable {

	private static final long serialVersionUID = -4906912674192274404L;
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int user_id;
	@NotBlank(message = "Please enter your name!")
	private String name;
	@NotBlank(message = "Please enter email address!")
	@Column(unique = true)
	private String email;
	@NotBlank(message = "Please enter password!")
	private String password;
	@NotBlank(message = "Please enter contact number!")
	private String contact;
	private String role = "CUSTOMER";
	private boolean enabled = true;

	@OneToOne(cascade = CascadeType.ALL, mappedBy = "user", fetch = FetchType.EAGER)
	private Cart cart;

	public Cart getCart() {
		return cart;
	}

	public void setCart(Cart cart) {
		this.cart = cart;
	}

	public int getUser_id() {
		return user_id;
	}

	public void setUser_id(int user_id) {
		this.user_id = user_id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getContact() {
		return contact;
	}

	public void setContact(String contact) {
		this.contact = contact;
	}

	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}

	public boolean getEnabled() {
		return enabled;
	}

	public void setEnabled(boolean enabled) {
		this.enabled = enabled;
	}

	@Override
	public String toString() {
		return "User [user_id=" + user_id + ", name=" + name + ", email=" + email + ", password=" + password
				+ ", contact=" + contact + ", role=" + role + ", enabled=" + enabled + ", cart=" + cart + "]";
	}

}
