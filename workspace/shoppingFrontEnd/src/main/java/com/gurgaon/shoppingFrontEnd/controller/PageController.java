package com.gurgaon.shoppingFrontEnd.controller;

import java.security.Principal;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.gurgaon.delhi.shoppingBackEnd.dao.ProductDao;
import com.gurgaon.delhi.shoppingBackEnd.dao.UserDao;
import com.gurgaon.delhi.shoppingBackEnd.dto.User;

//Use admin/index for admin folder and user/index for user
//admin/index
@Controller
public class PageController {

	@Autowired
	private ProductDao ProductDaoImpl;
	@Autowired
	UserDao userDao;
	
	@RequestMapping(value = { "/", "/index", "/home" })
	public String index(Principal principal, Model model) {
		if(principal!=null)
		{
			User user = userDao.getUserByUsername(principal.getName());
			if(user.getRole().equals("ADMIN"))
			{
				return "redirect:/admin/adminIndex";
			}
			else if(user.getRole().equals("USER"))
			{
				return "redirect:/user/userIndex";
			}
		}
		return "index";
	}

	/*@RequestMapping(value = "/Login")
	public ModelAndView Login() {
		ModelAndView mv = new ModelAndView("Login");
		return mv;
	}*/

	@GetMapping("/login")
	public String login(@RequestParam(value = "error", required = false)String error, Model model) {
	if(error!=null) {
	model.addAttribute("err	or","Authentication Failed - Invalid credentials!");
	}
	model.addAttribute("title", "Login");
	return "Login";
	}

	@RequestMapping(value = "/productList")
	public ModelAndView productList() {
		ModelAndView mv = new ModelAndView("productList");
		return mv;
	}
	/*
	 * @RequestMapping(value="/DataList") public ModelAndView list() {
	 * ModelAndView mv = new ModelAndView("productList");
	 * mv.addObject("product", productDao.productList()); return mv; }
	 */
	@RequestMapping(value = "/product11/{id}")
	public ModelAndView product11(@PathVariable("id") int id) {
		ModelAndView mv = new ModelAndView("product1");

		mv.addObject("msg", ProductDaoImpl.getProduct(id));
		return mv;
	}

	// For User
	@RequestMapping(value = "/user/index")
	public ModelAndView userIndex() {
		ModelAndView mv = new ModelAndView("user/userIndex");
		return mv;
	}
	// For User Cart
	@RequestMapping(value = "/user/cart")
	public ModelAndView userCart() {
		ModelAndView mv = new ModelAndView("user/cart");
		return mv;
	}
}