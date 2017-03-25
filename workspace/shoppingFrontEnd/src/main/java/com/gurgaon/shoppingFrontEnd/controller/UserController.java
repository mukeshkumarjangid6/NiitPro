package com.gurgaon.shoppingFrontEnd.controller;

import java.security.Principal;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.gurgaon.delhi.shoppingBackEnd.dao.CartItemDao;
import com.gurgaon.delhi.shoppingBackEnd.dao.ProductDao;
import com.gurgaon.delhi.shoppingBackEnd.dao.UserDao;
import com.gurgaon.delhi.shoppingBackEnd.dto.Cart;
import com.gurgaon.delhi.shoppingBackEnd.dto.CartItem;
import com.gurgaon.delhi.shoppingBackEnd.dto.Product;
import com.gurgaon.delhi.shoppingBackEnd.dto.User;

@Controller
public class UserController {
	@Autowired
	private ProductDao ProductDaoImpl;

	@Autowired
	private UserDao userDao;
	@Autowired
	private CartItemDao CartItemDaoImpl;
	private static User user;
	private static CartItem cartItem;
	private static Cart cart;
	private static Product product;
	boolean status;

	private List<CartItem> cartitems;

	// It's for providing User id to web flow in checkout
	@RequestMapping("/checkoutData")
	public String getCheckout(Principal principal) {
		user = userDao.getUserByUsername(principal.getName());

		return "redirect:/checkout?user_id=" + user.getUser_id();
	}

	// For User Cart
	@RequestMapping(value = "/user/cart")
	public ModelAndView userCart() {
		ModelAndView mv = new ModelAndView("user/cart");
		return mv;
	}

	// For for return list of cartItem from DataTable in cart.jsp
	@RequestMapping("/cart/cartItem/data")
	public @ResponseBody ModelAndView getCartItem(Principal principal) {
		ModelAndView model = new ModelAndView("user/cart");
		if (principal != null) {
			user = userDao.getUserByUsername(principal.getName());
			cart = user.getCart();
			cartitems = cart.getCartList();
			// model.addObject("titleMsg", "Cart Items");
			model.addObject("cartitems", cartitems);
			return model;
		}
		return null;
	}

	// For User add to cart result message
	@RequestMapping(value = "/user/result")
	public ModelAndView result() {
		ModelAndView mv = new ModelAndView("user/result");
		return mv;
	}

	// To view single product in a page
	@RequestMapping(value = "user/userViewProduct/{id}")
	public ModelAndView product11(@PathVariable("id") int id) {
		ModelAndView mv = new ModelAndView("user/userViewProduct");
		mv.addObject("msg", ProductDaoImpl.getProduct(id));
		return mv;
	}

	// To increase product quantity by + link
	@RequestMapping(value = "user/plusOneProductQuantity/{id}")
	public ModelAndView plusOneProductQuantity(@PathVariable("id") int id, Principal principal) {
		if (principal != null) {
			user = userDao.getUserByUsername(principal.getName());
			cart = user.getCart();
			product = ProductDaoImpl.getProduct(id);
			cartItem = CartItemDaoImpl.getCartItemByUserIdAndProductId(cart, product);
			cart = cartItem.getCart();
			product = cartItem.getProduct();
			int oldQuantity = cartItem.getSell_quantity();
			cartItem.setSell_quantity(cartItem.getSell_quantity() + 1);
			cartItem.setTotal_price(product.getPrice() * cartItem.getSell_quantity());
			cart.setGrandTotal(cart.getGrandTotal() + (cartItem.getSell_quantity() - oldQuantity) * product.getPrice());
			status = CartItemDaoImpl.updateCartItem(cartItem);
			// mv.addObject("status", status);
			return new ModelAndView("redirect:/cart/cartItem/data");
		}

		// mv.addObject("msg", ProductDaoImpl.getProduct(id));
		return new ModelAndView("redirect:/cart/cartItem/data");
	}

	// To decrease product quantity by - link
	@RequestMapping(value = "user/minusOneProductQuantity/{id}")
	public ModelAndView minusOneProductQuantity(@PathVariable("id") int id, Principal principal) {
		if (principal != null) {
			user = userDao.getUserByUsername(principal.getName());
			cart = user.getCart();
			product = ProductDaoImpl.getProduct(id);
			cartItem = CartItemDaoImpl.getCartItemByUserIdAndProductId(cart, product);
			cart = cartItem.getCart();
			product = cartItem.getProduct();
			int oldQuantity = cartItem.getSell_quantity();
			if (oldQuantity > 1) {
				cartItem.setSell_quantity(cartItem.getSell_quantity() - 1);
				cartItem.setTotal_price(product.getPrice() * cartItem.getSell_quantity());
				cart.setGrandTotal(
						cart.getGrandTotal() - (oldQuantity - cartItem.getSell_quantity()) * product.getPrice());
				status = CartItemDaoImpl.updateCartItem(cartItem);
			} else {
				return new ModelAndView("redirect:/cart/cartItem/data");
			}
			// mv.addObject("status", status);
			return new ModelAndView("redirect:/cart/cartItem/data");
		}

		// mv.addObject("msg", ProductDaoImpl.getProduct(id));
		return new ModelAndView("redirect:/cart/cartItem/data");
	}

	// Add new product in cart item and also update in cart
	@RequestMapping(value = "user/addProductToCartItem/{id}")
	public ModelAndView addProductToCartItem(@PathVariable("id") int id, Principal principal) {
		ModelAndView mv = new ModelAndView("/user/result");
		String msg = null;
		product = ProductDaoImpl.getProduct(id);
		if (principal != null) {
			user = userDao.getUserByUsername(principal.getName());
			cart = user.getCart();
			if ((cart.getCartItemCount() == 0) || (CartItemDaoImpl.searchCartItemByUserIdAndProductId(cart, product))) {
				cartItem = new CartItem();
				cartItem.setCart(user.getCart());
				cartItem.setProduct(product);
				cartItem.setSell_quantity(1);// compare with product available
												// quantity remaining and
												// display
												// err
				cartItem.setTotal_price(product.getPrice() * cartItem.getSell_quantity());

				cart.setGrandTotal(cart.getGrandTotal() + cartItem.getTotal_price());
				cart.setCartItemCount(cart.getCartItemCount() + 1);
				status = CartItemDaoImpl.addCartItem(cartItem);

			} else if (cart.getCartItemCount() != 0) {
				cartItem = CartItemDaoImpl.getCartItemByUserIdAndProductId(cart, product);
				cart = cartItem.getCart();
				product = cartItem.getProduct();
				int oldQuantity = cartItem.getSell_quantity();
				cartItem.setSell_quantity(cartItem.getSell_quantity() + 1);
				cartItem.setTotal_price(product.getPrice() * cartItem.getSell_quantity());
				cart.setGrandTotal(
						cart.getGrandTotal() + (cartItem.getSell_quantity() - oldQuantity) * product.getPrice());
				status = CartItemDaoImpl.updateCartItem(cartItem);

			}
			// This message will display in result.jsp page
			if (status) {
				msg = "Added to Cart";
			} else {
				msg = "Already in Cart";
			}
		}
		mv.addObject("msg", msg);
		return mv;
	}
}