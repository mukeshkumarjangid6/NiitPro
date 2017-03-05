package com.gurgaon.delhi.shoppingBackEnd.daoImpl;

import java.util.ArrayList;
import java.util.List;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.gurgaon.delhi.shoppingBackEnd.dao.CategoryDao;
import com.gurgaon.delhi.shoppingBackEnd.dto.Category;
@Repository("CategoryDaoImpl")
public class CategoryDaoImpl implements CategoryDao {
	@Autowired(required=true)
	private SessionFactory sessionFactory;
	
	private static List<Category> categories=new ArrayList<Category>();
	
	static {
		Category category=new Category();
		//add first category
		category.setId(1);
		category.setName("Nature");
		category.setDescription("This is Description for Nature Frame");
		category.setImg_url("Nature1.jpg");
		categories.add(category);
		//add second category
		category=new Category();
		category.setId(1);
		category.setName("Animal");
		category.setDescription("This is Description for Animal Frame");
		category.setImg_url("Animal1.jpg");
		categories.add(category);
	}
public List<Category> list() {
		return categories;
	}
public Category get(int id) {
	for(Category category: categories)
	{
		if(category.getId()==id)return category;
	}
	return null;
}
@Transactional
public boolean add(Category category) {
	try{
		//add the category to the database
		sessionFactory.getCurrentSession().persist(category);
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