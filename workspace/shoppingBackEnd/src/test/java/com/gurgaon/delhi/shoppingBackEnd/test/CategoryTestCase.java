package com.gurgaon.delhi.shoppingBackEnd.test;

import static org.junit.Assert.assertEquals;

import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.gurgaon.delhi.shoppingBackEnd.dao.Address1Dao;
import com.gurgaon.delhi.shoppingBackEnd.dao.ProductDao;
import com.gurgaon.delhi.shoppingBackEnd.dao.UserDao;
import com.gurgaon.delhi.shoppingBackEnd.dto.Address1;
import com.gurgaon.delhi.shoppingBackEnd.dto.Product;
import com.gurgaon.delhi.shoppingBackEnd.dto.User;

public class CategoryTestCase {
	private static AnnotationConfigApplicationContext context;

	private static ProductDao ProductDaoImpl;
	private Product product;
	private static UserDao userDaoImpl;
	private User user;
	private static Address1Dao address1DaoImpl;
	private Address1 address1;

	@BeforeClass
	public static void init() {
		context = new AnnotationConfigApplicationContext();
		context.scan("com.gurgaon.delhi.shoppingBackEnd");
		context.refresh();
		// categoryDao = (CategoryDao) context.getBean("CategoryDaoImpl");
		ProductDaoImpl = (ProductDao) context.getBean("ProductDaoImpl");
		userDaoImpl = (UserDao) context.getBean("UserDaoImpl");
		address1DaoImpl = (Address1Dao)context.getBean("Address1DaoImpl");
	}

/*	@Test
	public void testAddUser() {

		user = new User();
		user.setContact("9988556677");
		user.setEmail("mukesh@gmail.com");
		user.setEnabled(true);
		user.setName("Mukesh");
		user.setPassword("mukesh");
		user.setRole("CUSTOMER");
		assertEquals("Success to add a category inside the table", true, userDaoImpl.add(user));
		address1 = new Address1();
		address1.setAddressLine1("BG-6 Pachim Vihars");
		address1.setCity("Delhi");
		address1.setCountry("India");
		address1.setPincode("110036");
		address1.setState("Delhi");
		address1.setUser_id(1);
		assertEquals("Success to add a category inside the table", true, address1DaoImpl.add(address1));
	}*/

	/*
	 * @Test public void testAddCategory() {
	 */
	/*
	 * category = new Category(); category.setName("Nature");
	 * category.setDescription("This is Description for Nature Frame");
	 * category.setImg_url("Nature1.jpg"); category.setActive(true);
	 * assertEquals("Success to add a category inside the table", true,
	 * categoryDao.add(category));
	 */

	/*
	 * product = new Product(); product.setBrand("Meilleour");
	 * product.setName("Nature");
	 * product.setDescription("This is a Frame Photo");
	 * product.setCategoryId(1); product.setSupplier("Jackson Company");
	 * product.setProductImg_url("Nature1.jpg"); product.setPrice(500);
	 * product.setQuantity(10); product.setActive(true);
	 * assertEquals("Success to add a product inside the table", true,
	 * ProductDaoImpl.add(product)); }
	 */

	/*
	 * @Test public void testGetCategory() { category=new Category(); category =
	 * categoryDao.get(1);
	 * assertEquals("Success to Fached a single category from the table"
	 * ,"Nature",category.getName());
	 * 
	 * product = new Product(); product = ProductDaoImpl.getProduct(1);
	 * assertEquals("Success to Fached a single product from the table"
	 * ,"Nature1",product.getName()); }
	 */

	/*
	 * @Test public void testUpdateCategory() {
	 * 
	 * Category category=new Category(); category = categoryDao.get(1);
	 * category.setName("Animal");
	 * assertEquals("Success to updae a single category from the table",
	 * true,categoryDao.update(category));
	 * 
	 * product = new Product(); product = ProductDaoImpl.getProduct(33);
	 * product.setPrice(899);
	 * assertEquals("Success to update a single product from the table",true,
	 * ProductDaoImpl.update(product)); }
	 */

	/*
	 * @Test public void testDeleteCategory() { category=new Category();
	 * category = categoryDao.get(1);
	 * assertEquals("Success to Dalete a single category from the table",
	 * true,categoryDao.delete(category));
	 * 
	 * product = new Product(); product = ProductDaoImpl.getProduct(1);
	 * assertEquals("Success to Dalete a single product from the table",true,
	 * ProductDaoImpl.delete(product)); }
	 */
	/*
	 * @Test public void testListCategory() { category=new Category();
	 * 
	 * assertEquals("Success to fetched the list category from the table",
	 * 1,categoryDao.list().size());
	 * 
	 * product = new Product();
	 * 
	 * assertEquals("Success to fetched the list of product from the table",1,
	 * ProductDaoImpl.productList().size()); }
	 */

	/*
	 * @Test public void testCrudCategoryProduct() { //Add operation
	 * category=new Category(); category.setName("Dog");
	 * category.setDescription("This is Description for Nature Frame Category");
	 * category.setImg_url("Nature1.jpg");
	 * assertEquals("Success to add a category inside the table",true,
	 * categoryDao.add(category));
	 * 
	 * product = new Product(); product.setBrand("Meilleour");
	 * product.setName("Nature");
	 * product.setDescription("This is a Frame Photo");
	 * product.setCategoryId(1); product.setSupplier("Jackson Company");
	 * product.setProductImg_url("Nature1.jpg"); product.setPrice(500);
	 * product.setQuantity(10);
	 * assertEquals("Success to add a product inside the table",true,
	 * ProductDaoImpl.add(product));
	 * 
	 * category=null; category=new Category(); category.setName("Animal");
	 * category.setDescription("This is Description for Animal Frame Category");
	 * category.setImg_url("Animal1.jpg");
	 * assertEquals("Success to add a category inside the table",true,
	 * categoryDao.add(category));
	 * 
	 * product=null; product = new Product(); product.setBrand("Meilleour");
	 * product.setName("Animal");
	 * product.setDescription("This is a Animal Frame Photo");
	 * product.setCategoryId(1); product.setSupplier("Jackson Company");
	 * product.setProductImg_url("Animal1.jpg"); product.setPrice(500);
	 * product.setQuantity(10);
	 * assertEquals("Success to add a product inside the table",true,
	 * ProductDaoImpl.add(product));
	 * 
	 * //fethcing and updating category and product category=null; category=new
	 * Category(); category = categoryDao.get(1); category.setName("Nature");
	 * assertEquals("Success to updae a single category from the table",
	 * true,categoryDao.update(category));
	 * 
	 * product=null; product = new Product(); product =
	 * ProductDaoImpl.getProduct(1); product.setPrice(899);
	 * assertEquals("Success to update a single product from the table",true,
	 * ProductDaoImpl.update(product));
	 * 
	 * //Delete the category category=null; category=new Category(); category =
	 * categoryDao.get(1);
	 * assertEquals("Success to Dalete a single category from the table",
	 * true,categoryDao.delete(category));
	 * 
	 * product=null; product = new Product(); product =
	 * ProductDaoImpl.getProduct(1);
	 * assertEquals("Success to Dalete a single product from the table",true,
	 * ProductDaoImpl.delete(product));
	 * 
	 * //fetch the list category=null; category=new Category();
	 * assertEquals("Success to fetched the list category from the table",
	 * 1,categoryDao.list().size());
	 * 
	 * product=null; product = new Product();
	 * assertEquals("Success to fetched the list of product from the table",1,
	 * ProductDaoImpl.productList().size()); }
	 */

}