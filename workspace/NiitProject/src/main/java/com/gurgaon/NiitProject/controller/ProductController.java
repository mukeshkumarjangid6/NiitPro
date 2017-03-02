package com.gurgaon.NiitProject.controller;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import dao.Product;
import dao.ProductDao;
@Controller
@RequestMapping("/product1")
public class ProductController {
@Autowired
private ProductDao product1;
@RequestMapping(value="/all/data")
@ResponseBody
public List<Product> getProducts()
{
	return product1.productList();
}
}