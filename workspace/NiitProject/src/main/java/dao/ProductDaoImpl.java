package dao;

import java.util.ArrayList;

import java.util.List;

import org.springframework.stereotype.Repository;

@Repository("product1")
public class ProductDaoImpl implements ProductDao{
	
	List<Product> products;
	Product p1;
	
	public void ProductLi()
	{
		products = new ArrayList<Product>();
		
		p1=new Product();
		p1.setID(1);
		p1.setBrand("Meilleour");
		p1.setName("Nature1");
		p1.setDescription("This is the nature Frame Photo");
		p1.setCategory("Nature");
		p1.setSupplier("Niit");
		p1.setImg_url("Img Url");
		p1.setPrice(200);
		p1.setQuantity(10);
		products.add(p1);
		
		p1=new Product();
		p1.setID(2);
		p1.setBrand("Meilleour");
		p1.setName("Animal1");
		p1.setDescription("This is the Animal Frame Photo");
		p1.setCategory("Nature");
		p1.setSupplier("Niit");
		p1.setImg_url("Img Url");
		p1.setPrice(200);
		p1.setQuantity(10);
		products.add(p1);
		
		p1=new Product();
		p1.setID(3);
		p1.setBrand("Meilleour");
		p1.setName("Nature1");
		p1.setDescription("This is the nature Frame Photo");
		p1.setCategory("Nature");
		p1.setSupplier("Niit");
		p1.setImg_url("Img Url");
		p1.setPrice(200);
		p1.setQuantity(10);
		products.add(p1);
	}
	
	public Product getProduct(int id)
	{
		return products.get(id);
	}
	public List<Product> productList()
	{
		
		ProductLi();
		System.out.println("Product List Reached");
		 for (Product a  : products) {
	         System.out.print(a.getName()+" ");
	         System.out.print(a.getBrand()+" ");
	         System.out.print(a.getCategory()+" ");
	         System.out.print(a.getDescription()+" ");
	         System.out.print(a.getImg_url()+" ");
	         System.out.print(a.getQuantity()+" ");
	      }
		return products;
	}
}