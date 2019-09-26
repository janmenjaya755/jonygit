package com.marlabs.product.service;

import com.marlabs.product.dao.ProductDao;
import com.marlabs.product.model.Product;

public class ProductService {
	ProductDao productdao;
	public String  insert(Product product) {
		int result1=productdao.save(product);
		if(result1==1) {
			return "data insert succesfully";
		}
			else {
				return "not insert data";
			}
		}
		
	}
	


