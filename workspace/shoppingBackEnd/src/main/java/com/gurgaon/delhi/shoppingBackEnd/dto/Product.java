package com.gurgaon.delhi.shoppingBackEnd.dto;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Transient;
import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.NotBlank;
import org.hibernate.validator.constraints.Range;
import org.springframework.web.multipart.MultipartFile;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
public class Product implements Serializable {
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	@NotBlank(message = "Can not leave this field witout entering value")
	@Size(min = 3, message = "Field must contain greater than 3 character")
	private String brand;
	@Size(min = 3, message = "Field must be greater than 3 character")
	@NotBlank(message = "Can not leave this field witout entering value")
	private String name;
	@Size(min = 3, message = "Field must be greater than 3 character")
	@NotBlank(message = "Can not leave this field witout entering value")
	private String description;

	// private int categoryId;
	@NotBlank(message = "Can not leave this field witout entering value")
	@Size(min = 3, message = "Field must contain greater than 3 character")
	private String supplier;
	private String productImg_url;
	@Range(min = 0, max = 2000, message = "Product Quantity must be greater than 0")
	private int price;
	@Range(min = 0, max = 2000, message = "Product Quantity must be within 0 and 200")
	private int quantity;// Available Quantity

	private boolean ActiveIs = true;

	@Transient
	@JsonIgnore
	MultipartFile file;
/*
	@OneToOne
	@JoinColumn(name = "cartItem_Id")
	private CartItem cartItem;*/
	// setter getter

	public MultipartFile getFile() {
		return file;
	}

/*	public CartItem getCartItem() {
		return cartItem;
	}

	public void setCartItem(CartItem cartItem) {
		this.cartItem = cartItem;
	}*/

	public void setDescription(String description) {
		this.description = description;
	}

	public void setId(int id) {
		this.id = id;
	}

	public void setFile(MultipartFile file) {
		this.file = file;
	}

	/*
	 * @NotEmpty
	 * 
	 * @ManyToOne(cascade = CascadeType.ALL)
	 * 
	 * @JoinColumn(name = "cat_id")
	 * 
	 * @JsonManagedReference private Category category;
	 * 
	 * public Category getCategory() { return category; }
	 * 
	 * public void setCategory(Category category) { this.category = category; }
	 */

	public boolean isActiveIs() {
		return ActiveIs;
	}

	public void setActiveIs(boolean activeIs) {
		ActiveIs = activeIs;
	}

	public String getBrand() {
		return brand;
	}

	public int getId() {
		return id;
	}

	public void setBrand(String brand) {
		this.brand = brand;
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

	/*
	 * public void setDescription(String description) { this.description =
	 * description; }
	 * 
	 * public int getCategoryId() { return categoryId; }
	 * 
	 * public void setCategoryId(int categoryId) { this.categoryId = categoryId;
	 * }
	 */

	public String getSupplier() {
		return supplier;
	}

	public void setSupplier(String supplier) {
		this.supplier = supplier;
	}

	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	public String getProductImg_url() {
		return productImg_url;
	}

	public void setProductImg_url(String productImg_url) {
		this.productImg_url = productImg_url;
	}

	@Override
	public String toString() {
		return "Product [id=" + id + ", brand=" + brand + ", name=" + name + ", description=" + description
				+ ", supplier=" + supplier + ", productImg_url=" + productImg_url + ", price=" + price + ", quantity="
				+ quantity + ", ActiveIs=" + ActiveIs + ", file=" + file + "]";
	}

}