package com.gurgaon.delhi.shoppingBackEnd.test;

import static org.junit.Assert.assertEquals;

import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.gurgaon.delhi.shoppingBackEnd.dao.CategoryDao;
import com.gurgaon.delhi.shoppingBackEnd.dao.ProductDao;
import com.gurgaon.delhi.shoppingBackEnd.dto.Category;
import com.gurgaon.delhi.shoppingBackEnd.dto.Product;

public class CategoryTestCase {
private static AnnotationConfigApplicationContext context;

private static CategoryDao categoryDao;
private static ProductDao ProductDaoImpl;
private Category category;
private Product product;
@BeforeClass
public static void init()
{
	context = new AnnotationConfigApplicationContext();
	context.scan("com.gurgaon.delhi.shoppingBackEnd");
	context.refresh();
	categoryDao = (CategoryDao)context.getBean("CategoryDaoImpl");
	ProductDaoImpl = (ProductDao)context.getBean("ProductDaoImpl");
}
@Test
public void testAddCategory()
{
	category=new Category();
	
	category.setName("Nature");
	category.setDescription("This is Description for Nature Frame");
	category.setImg_url("Nature1.jpg");
	assertEquals("Success to add a category inside the table",true,categoryDao.add(category));
	
	product = new Product();
	product.setBrand("Meilleour");
	product.setName("Nature");
	product.setDescription("This is a Frame Photo");
	product.setCategoryId(1);
	product.setSupplier("Jackson Company");
	product.setProductImg_url("Nature1.jpg");
	product.setPrice(500);
	product.setQuantity(10);
	assertEquals("Success to add a product inside the table",true,ProductDaoImpl.add(product));
}
}