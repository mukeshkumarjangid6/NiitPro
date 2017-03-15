/*package com.gurgaon.shoppingFrontEnd.controller;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import com.gurgaon.delhi.shoppingBackEnd.dao.UserDao;
import com.gurgaon.delhi.shoppingBackEnd.dto.User;

@Controller
public class UserController {
	@Autowired
	HttpServletRequest request;
	@Autowired
	private UserDao userDao;*/

/*	@RequestMapping(value = "/Register")
	public ModelAndView Register() {
		ModelAndView mv = new ModelAndView("Register");
		mv.addObject("user", new User());
		return mv;
	}*/
/*
	@RequestMapping(value = "/userRegistration.do", method = RequestMethod.POST)
	private ModelAndView doActions(@ModelAttribute("user") @Valid User user, BindingResult result) {
		User userResult = new User();
		if (result.hasErrors()) {
			ModelAndView model1 = new ModelAndView("/Register");
			model1.addObject("title", "Product Management");
			return model1;
		}*/
		/*
		 * switch (action.toLowerCase()) { case "add": if
		 * (!(product.getFile().getOriginalFilename().equals(""))) {
		 * product.setProductImg_url(uploadImage(product.getFile())); }
		 * System.out.println("Image uploaded"); productDao.add(product);
		 * productResult = product; break; case "update":
		 * productDao.update(product); productResult = product; break; case
		 * "delete": productDao.delete(product.getId()); productResult =
		 * product; break; }
		 */
/*		ModelAndView model1 = new ModelAndView("/user/userIndex");
		userDao.add(user);
		model1.addObject("user", user);
		model1.addObject("success", "Data has been processed");
		return model1;
	}*/
/*}*/