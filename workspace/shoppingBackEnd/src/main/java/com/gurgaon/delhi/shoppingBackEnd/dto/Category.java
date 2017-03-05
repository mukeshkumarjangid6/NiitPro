package com.gurgaon.delhi.shoppingBackEnd.dto;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;


@Entity
public class Category {

	@OneToMany(mappedBy = "category", cascade = CascadeType.ALL)
	private Set<Product> product=new HashSet<Product>(0);
	
	public Set<Product> getProduct() {
		return product;
	}
	public void setProduct(Set<Product> product) {
		this.product = product;
	}
	//Setter and Getter
	public int getId() {
		return cat_id;
	}
	public void setId(int cat_id) {
		this.cat_id = cat_id;
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
	public boolean isActive() {
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

	//Private Fields
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int cat_id;
	private String name;
	private String description;
	@Column(name="img_url")
	private String imageURL;
	@Column(name="is_active")
	private boolean active=true; 
	//End Private Fields
	
}