package com.gurgaon.delhi.shoppingBackEnd.dto;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Category implements Serializable{
/*	@NotEmpty
	@OneToMany(mappedBy = "category", cascade = CascadeType.ALL)
	@JsonBackReference
	private List<Product> product = new ArrayList<Product>();

	public List<Product> getProduct() {
		return product;
	}

	public void setProduct(List<Product> product) {
		this.product = product;
	}*/

	// Setter and Getter
	public int getId() {
		return cat_id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getImg_url() {
		return imageURL;
	}

	public void setImg_url(String img_url) {
		this.imageURL = img_url;
	}

	public boolean getActive() {
		return active;
	}

	public void setActive(boolean active) {
		this.active = active;
	}

	@Override
	public String toString() {
		return "Category [id=" + cat_id + ", name=" + name + ", description=" + description + ", imageURL=" + imageURL
				+ ", active=" + active + "]";
	}

	// Private Fields
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int cat_id;

	//@NotEmpty
	private String name;

	//@NotEmpty
	private String description;
	//@NotEmpty
	@Column(name = "img_url")
	private String imageURL;
	//@NotEmpty
	@Column(name = "active_is")
	private boolean active = true;
	// End Private Fields

}