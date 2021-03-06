package com.gurgaon.delhi.shoppingBackEnd.test;

import static org.junit.Assert.*;

import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.gurgaon.delhi.shoppingBackEnd.dao.CartDao;
import com.gurgaon.delhi.shoppingBackEnd.dao.CartItemDao;
import com.gurgaon.delhi.shoppingBackEnd.dao.PaymentDao;
import com.gurgaon.delhi.shoppingBackEnd.dao.ProductDao;
import com.gurgaon.delhi.shoppingBackEnd.dao.UserDao;
import com.gurgaon.delhi.shoppingBackEnd.dto.Cart;
import com.gurgaon.delhi.shoppingBackEnd.dto.CartItem;
import com.gurgaon.delhi.shoppingBackEnd.dto.Payment;
import com.gurgaon.delhi.shoppingBackEnd.dto.Product;
import com.gurgaon.delhi.shoppingBackEnd.dto.User;

public class CartTestCase {
	private static AnnotationConfigApplicationContext context;
	private static CartDao cartDao;
	private static CartItemDao cartItemDao;
	private static UserDao userDao;
	private static ProductDao productDao;
	private User user;
	private Cart cart;
	private CartItem cartItem;
	private Product product, pro;

	private Payment payment;
	private static PaymentDao paymentDao;

	@BeforeClass
	public static void init() {
		context = new AnnotationConfigApplicationContext();
		context.scan("com.gurgaon.delhi.shoppingBackEnd");
		context.refresh();

		cartDao = (CartDao) context.getBean("CartDaoImpl");
		cartItemDao = (CartItemDao) context.getBean("CartItemDaoImpl");
		userDao = (UserDao) context.getBean("UserDaoImpl");
		productDao = (ProductDao) context.getBean("ProductDaoImpl");

		paymentDao = (PaymentDao) context.getBean("PaymentDaoImpl");

	}

	// to get payment details

/*	@Test
	public void testAddPayment() {

		user = userDao.getUserById(65);
		payment = paymentDao.getPaymentDetails(user);
		assertEquals("Successfully added the Payment!", "Mukesh", payment.getCardName());
	}*/

	// to add payment
	/*
	 * @Test public void testAddPayment() {
	 * 
	 * user = userDao.getUserById(65); payment = new Payment();
	 * payment.setCardName("Mukesh"); payment.setCardno("5105105105105100");
	 * payment.setMm(06); payment.setUser(user); payment.setYy(17);
	 * assertEquals("Successfully added the Payment!", true,
	 * paymentDao.add(payment)); }
	 */

	// to delete all cartItems of a cart related to a user
	/*
	 * @Test public void testAddCartItem() { user = userDao.getUserById(3); cart
	 * = user.getCart(); assertEquals("Successfully deleted the cartItems!",
	 * true,cartDao.deleteAllCartItems(cart)); }
	 */

	/*
	 * @Test public void testAddCartItem() { user = userDao.getUserById(1);
	 * product = productDao.getProduct(1); //user = userDao.getUserById(); cart
	 * = user.getCart(); cartItem =
	 * cartItemDao.getCartItemByUserIdAndProductId(cart, product);
	 * System.out.println("Cart "+cartItem.getCart().getCartItemCount());
	 * System.out.println(cartItem.getProduct().getName());
	 * 
	 * }
	 */
	/*
	 * @Test public void testDeleteProductCartItem() { user =
	 * userDao.getUserById(102); cart = user.getCart(); //product =
	 * productDao.getProduct(1); List<CartItem> cartitems = cart.getCartList();
	 * 
	 * for(CartItem cartItem1:cartitems) { pro = cartItem1.getProduct();
	 * System.out.println(pro.getBrand()); } }
	 */

	// Adding new Product

	/*
	 * @Test public void testAddProductCartItem() { product = new Product();
	 * product.setActiveIs(true); product.setBrand("Medifast");
	 * product.setDescription("This is the Medifast photo frame");
	 * product.setFile(null); product.setName("Medifast Photo Frame");
	 * product.setPrice(500); product.setProductImg_url("Animal.jpg");
	 * product.setQuantity(20); product.setSupplier("Mumbai Hut");
	 * 
	 * assertEquals("Successfully added the product!", true,
	 * productDao.add(product));
	 * 
	 * user = userDao.getUserById(1); cartItem = new CartItem();
	 * cartItem.setCart(user.getCart()); cartItem.setProduct(product);
	 * cartItem.setSell_quantity(4); cartItem.setTotal_price(product.getPrice()
	 * * cartItem.getSell_quantity()); cart = user.getCart();
	 * cart.setGrandTotal(cart.getGrandTotal() + cartItem.getTotal_price());
	 * cart.setCartItemCount(cart.getCartItemCount() + 1);
	 * 
	 * assertEquals("Successfully added the cartItem!", true,
	 * cartItemDao.addCartItem(cartItem)); }
	 */

	// Delete existing product quantity from cartItem

	/*
	 * @Test public void testDeleteCartItem() { cartItem =
	 * cartItemDao.getCartItemByCartItem_Id(99); cart = cartItem.getCart();
	 * product = cartItem.getProduct(); int oldQuantity =
	 * cartItem.getSell_quantity();
	 * cartItem.setSell_quantity(cartItem.getSell_quantity()-1);
	 * cartItem.setTotal_price(product.getPrice()*cartItem.getSell_quantity());
	 * cart.setGrandTotal(cart.getGrandTotal()-(oldQuantity-cartItem.
	 * getSell_quantity())*product.getPrice()); assertEquals(
	 * "Successfully Update the cartItem!", true,
	 * cartItemDao.updateCartItem(cartItem)); }
	 */

	// Add product quantity by one in existing product
	/*
	 * @Test public void testUpdateCartItem() { cartItem =
	 * cartItemDao.getCartItemByCartItem_Id(69); cart = cartItem.getCart();
	 * product = cartItem.getProduct(); int oldQuantity =
	 * cartItem.getSell_quantity();
	 * cartItem.setSell_quantity(cartItem.getSell_quantity()+1);
	 * cartItem.setTotal_price(product.getPrice()*cartItem.getSell_quantity());
	 * cart.setGrandTotal(cart.getGrandTotal()+(cartItem.getSell_quantity()-
	 * oldQuantity)*product.getPrice()); assertEquals(
	 * "Successfully Update the cartItem!", true,
	 * cartItemDao.updateCartItem(cartItem)); }
	 */

	// create and insert data, create user first time with cart object which is
	// available in dao class

	/*
	 * @Test public void testAddCartItem() { user = new User();
	 * user.setContact("9988556677"); user.setEmail("admin@gmail.com");
	 * user.setEnabled(true); user.setName("admin"); user.setPassword("admin");
	 * user.setRole("ADMIN"); user.setAddress("Delhi");
	 * 
	 * product = new Product(); product.setActiveIs(true);
	 * product.setBrand("Meilleour");
	 * product.setDescription("This is the Meilleour photo frame");
	 * product.setFile(null); product.setName("Nature"); product.setPrice(1000);
	 * product.setProductImg_url("Nature.jpg"); product.setQuantity(50);
	 * product.setSupplier("Jindal & sons");
	 * 
	 * assertEquals("Successfully added the User!", true, userDao.add(user));
	 * assertEquals("Successfully added the product!", true,
	 * productDao.add(product));
	 * 
	 * cartItem = new CartItem(); cartItem.setCart(user.getCart());
	 * 
	 * // product.setCartItem(cartItem); cartItem.setProduct(product);
	 * cartItem.setSell_quantity(5); cartItem.setTotal_price(product.getPrice()
	 * * cartItem.getSell_quantity());
	 * 
	 * cart = user.getCart(); cart.setGrandTotal(cart.getGrandTotal() +
	 * cartItem.getTotal_price()); cart.setCartItemCount(cart.getCartItemCount()
	 * + 1);
	 * 
	 * assertEquals("Successfully added the cartItem!", true,
	 * cartItemDao.addCartItem(cartItem));
	 * 
	 * }
	 */

}