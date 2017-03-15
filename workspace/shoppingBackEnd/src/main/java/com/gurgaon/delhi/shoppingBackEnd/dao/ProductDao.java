package com.gurgaon.delhi.shoppingBackEnd.dao;

import java.util.List;

import com.gurgaon.delhi.shoppingBackEnd.dto.Product;

public interface ProductDao {

public Product getProduct(int id);

public List <Product> productList();

boolean add(Product product);

boolean update(Product product);

boolean delete(int id);
}