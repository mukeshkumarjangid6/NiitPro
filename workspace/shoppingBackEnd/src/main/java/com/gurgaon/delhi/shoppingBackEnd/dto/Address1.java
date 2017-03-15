package com.gurgaon.delhi.shoppingBackEnd.dto;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import org.hibernate.validator.constraints.NotBlank;
@Entity
public class Address1 {
	private static final long serialVersionUID = -4906912674192274404L;
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int address_id;
	@NotBlank(message = "Please enter Address!")
	private String addressLine1;
	@NotBlank(message = "Please enter City!")
	private String city;
	@NotBlank(message = "Please enter Country!")
	private String country;
	@NotBlank(message = "Please enter Pin Code!")
	private String pincode;
	@NotBlank(message = "Please enter State!")
	private String state;

	private int user_id;

	public int getAddress_id() {
		return address_id;
	}

	public void setAddress_id(int address_id) {
		this.address_id = address_id;
	}

	public String getAddressLine1() {
		return addressLine1;
	}

	public void setAddressLine1(String addressLine1) {
		this.addressLine1 = addressLine1;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}

	public String getPincode() {
		return pincode;
	}

	public void setPincode(String pincode) {
		this.pincode = pincode;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public int getUser_id() {
		return user_id;
	}

	public void setUser_id(int user_id) {
		this.user_id = user_id;
	}

	@Override
	public String toString() {
		return "Address1 [address_id=" + address_id + ", addressLine1=" + addressLine1 + ", city=" + city + ", country="
				+ country + ", pincode=" + pincode + ", state=" + state + ", user_id=" + user_id + "]";
	}


}
