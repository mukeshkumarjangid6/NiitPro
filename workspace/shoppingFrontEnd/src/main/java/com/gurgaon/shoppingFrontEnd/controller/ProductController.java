package com.gurgaon.shoppingFrontEnd.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.gurgaon.delhi.shoppingBackEnd.dao.CategoryDao;
import com.gurgaon.delhi.shoppingBackEnd.dao.ProductDao;
import com.gurgaon.delhi.shoppingBackEnd.dto.Product;

@Controller
public class ProductController {
	@Autowired
	private ProductDao ProductDaoImpl;
	@Autowired
	private CategoryDao categoryDaoImpl;

	@RequestMapping("/product1/all/data")
	public @ResponseBody List<Product> getProducts() {
		return ProductDaoImpl.productList();
	}

/*	@RequestMapping("/product1/all/categories")
	public @ResponseBody List<Category> getCategories() {
		return categoryDaoImpl.list();
	}*/
}