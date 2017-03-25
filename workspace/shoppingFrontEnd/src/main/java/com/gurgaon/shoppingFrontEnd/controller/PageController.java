package com.gurgaon.shoppingFrontEnd.controller;

import java.security.Principal;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.gurgaon.delhi.shoppingBackEnd.dao.ProductDao;
import com.gurgaon.delhi.shoppingBackEnd.dao.UserDao;
import com.gurgaon.delhi.shoppingBackEnd.dto.Product;
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

		if (principal != null) {
			User user = userDao.getUserByUsername(principal.getName());
			if (user.getRole().equalsIgnoreCase("ADMIN")) {
				return "redirect:/admin/adminIndex";
			} else if (user.getRole().equalsIgnoreCase("CUSTOMER")) {
				return "redirect:/user/index";
			}
		}
		return "index";
	}

	@GetMapping("/login")
	public String login(@RequestParam(value = "error", required = false) String error, Model model) {
		if (error != null) {
			model.addAttribute("error", "Authentication Failed - Invalid credentials!");
		}
		model.addAttribute("title", "Login");
		return "Login";
	}

	// For display result page after register user
	@RequestMapping(value = "/RegResultPage")
	public ModelAndView RegResultPage() {
		ModelAndView mv = new ModelAndView("result");
		return mv;
	}

	// For User
	@RequestMapping(value = "/user/index")
	public ModelAndView userIndex() {
		ModelAndView mv = new ModelAndView("user/userIndex");
		return mv;
	}

	// For List of Products in productList.jsp
	@RequestMapping(value = "/productList")
	public ModelAndView productList() {
		ModelAndView mv = new ModelAndView("productList");
		return mv;
	}

	// For for return list of product in DataTable in productList.jsp
	@RequestMapping("/product1/all/data")
	public @ResponseBody List<Product> getProducts() {
		return ProductDaoImpl.productList();
	}

	// For single product in product1.jsp
	@RequestMapping(value = "/product11/{id}")
	public ModelAndView product11(@PathVariable("id") int id) {
		ModelAndView mv = new ModelAndView("product1");
		mv.addObject("msg", ProductDaoImpl.getProduct(id));
		return mv;
	}
	/*
	 * for CategoryList
	 * 
	 * @RequestMapping("/product1/all/categories") public @ResponseBody
	 * List<Category> getCategories() { return categoryDaoImpl.list(); }
	 */
}