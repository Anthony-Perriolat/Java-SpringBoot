package com.blog.blog.controller;


import com.blog.blog.dao.ProductDao;
import com.blog.blog.model.Product;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;


@RestController
public class ProductContoller {
	
	// autorisation 
	@Autowired
	private ProductDao productDao;
	
	// Products
	
	@GetMapping(value = "produits")
	public List<Product> listeProduits(){
		return productDao.findAll();
	}

	//Produits/{id}
 
	// definir la méthode d'envoie et l'url
	@GetMapping(value = "produits/{id}")
	// class qui corespond à une méthode du controller 
	public Product afficherUnArticle(@PathVariable int id) {
		
		Product product = new Product(id, new String("aspirateur"), 1000);
		
		return product;
		
	}
}
