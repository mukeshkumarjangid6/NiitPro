package com.gurgaon.delhi.shoppingBackEnd.daoImpl;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.gurgaon.delhi.shoppingBackEnd.dao.ProductDao;
import com.gurgaon.delhi.shoppingBackEnd.dto.Category;
import com.gurgaon.delhi.shoppingBackEnd.dto.Product;

@Repository("ProductDaoImpl")
public class ProductDaoImpl implements ProductDao{
	
	@Autowired(required=true)
	private SessionFactory sessionFactory;
	
private static List<Product> products=new ArrayList<Product>();

	static {
		Product product=new Product();
		//add first category
		product.setBrand("Meilleour");
		product.setName("Nature");
		product.setDescription("This is a Frame Photo");
		product.setCategoryId(1);
		product.setSupplier("Jackson Company");
		product.setProductImg_url("Nature1.jpg");
		product.setPrice(500);
		product.setQuantity(10);
		
		products.add(product);
		//add second category
		product.setBrand("Meilleour");
		product.setName("Animal");
		product.setDescription("This is a Frame Photo");
		product.setCategoryId(1);
		product.setSupplier("Jackson Company");
		product.setProductImg_url("Animal1.jpg");
		product.setPrice(1000);
		product.setQuantity(20);
		products.add(product);
	}
	
	@SuppressWarnings("unchecked")
	public List<Product> productList()
	{
		return products;
	}
	
	public Product getProduct(int id)
	{
		for(Product product: products)
		{
			if(product.getID()==id)return product;
		}
		return null;
	}
	@Transactional
	public boolean add(Product product) {
		try{
			//add the category to the database
			sessionFactory.getCurrentSession().persist(product);
			return true;
		}
		catch(Exception ex)
		{
			ex.printStackTrace();
			return false;
		}
	}

	public boolean update(Category category) {
		// TODO Auto-generated method stub
		return false;
	}

	public boolean delete(Category category) {
		// TODO Auto-generated method stub
		return false;
	}
}