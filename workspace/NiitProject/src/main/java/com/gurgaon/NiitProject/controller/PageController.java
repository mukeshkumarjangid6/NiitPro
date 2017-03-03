package com.gurgaon.NiitProject.controller;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import dao.ProductDao;

@Controller
public class PageController {
	
	@Autowired
	private ProductDao productDao;
	
	@RequestMapping(value={"/","/index","/home"})
	public ModelAndView index(){
	ModelAndView mv=new ModelAndView("index");
			return mv;
	}
	
	@RequestMapping(value="/Login")
	public ModelAndView Login(){
	ModelAndView mv=new ModelAndView("Login");
			return mv;
	}

	@RequestMapping(value="/Register")
	public ModelAndView Register(){
	ModelAndView mv=new ModelAndView("Register");
			return mv;
	}
	
	@RequestMapping(value="/productList")
	public ModelAndView productList(){
	ModelAndView mv=new ModelAndView("productList");
			return mv;
	}
	@RequestMapping(value="/DataList")
	public ModelAndView list()
	{
		ModelAndView mv = new ModelAndView("productList");
		mv.addObject("product", productDao.productList());
		return mv;
	}
}