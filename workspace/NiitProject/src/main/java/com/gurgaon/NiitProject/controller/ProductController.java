package com.gurgaon.NiitProject.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.gurgaon.NiitProject.dao.Product;
import com.gurgaon.NiitProject.dao.ProductDao;

@Controller
public class ProductController {
	@Autowired(required=false)
	private ProductDao product1;

	@RequestMapping("/product1/all/data")
	public @ResponseBody List<Product> getProducts() {
		return product1.productList();
	}
}