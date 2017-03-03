package com.gurgaon.NiitProject.dao;

import java.util.List;



import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository("product1")
@Transactional
public class ProductDaoImpl implements ProductDao{
	
	@Autowired(required=false)
	private SessionFactory sessionFactory;
	

	
	public Product getProduct(int id)
	{
		return sessionFactory.openSession().get(Product.class, Integer.valueOf(id));
	}
	@SuppressWarnings("unchecked")
	public List<Product> productList()
	{
		return sessionFactory.openSession().createQuery("from Product").list();
	}
}