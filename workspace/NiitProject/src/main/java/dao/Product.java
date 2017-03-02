package dao;

public class Product {
private int ID;
private String Brand;
private String Name;
private String Description;
private String Category; 
private String Supplier;
private String Img_url;
private int Price, Quantity;
public int getID() {
	return ID;
}
public void setID(int iD) {
	ID = iD;
}
public String getBrand() {
	return Brand;
}
public void setBrand(String brand) {
	Brand = brand;
}
public String getName() {
	return Name;
}
public void setName(String name) {
	Name = name;
}
public String getDescription() {
	return Description;
}
public void setDescription(String description) {
	Description = description;
}
public String getCategory() {
	return Category;
}
public void setCategory(String category) {
	Category = category;
}
public String getSupplier() {
	return Supplier;
}
public void setSupplier(String supplier) {
	Supplier = supplier;
}
public int getPrice() {
	return Price;
}
public void setPrice(int price) {
	Price = price;
}
public int getQuantity() {
	return Quantity;
}
public void setQuantity(int quantity) {
	Quantity = quantity;
}
public String getImg_url() {
	return Img_url;
}
public void setImg_url(String img_url) {
	Img_url = img_url;
}

}