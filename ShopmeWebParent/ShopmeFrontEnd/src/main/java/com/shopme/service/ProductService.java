package com.shopme.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.shopme.common.entity.Product;
import com.shopme.common.error.ProductNotFoundException;
import com.shopme.controller.ProductController;
import com.shopme.repository.ProductRepository;
import com.shopme.service.impl.IProductService;

@Service
public class ProductService implements IProductService{
	
	private static final Logger LOGGER = LoggerFactory.getLogger(ProductService.class);

	public static final int PRODUCTS_PER_PAGE = 10;

	@Autowired 
	private ProductRepository repo;
	
	@Override
	public Page<Product> listByCategory(int pageNum, Integer categoryId) {
		// TODO Auto-generated method stub
		
		LOGGER.info("ProductService | listByCategory is called");
		
		String categoryIdMatch = "-" + String.valueOf(categoryId) + "-";
		Pageable pageable = PageRequest.of(pageNum - 1, PRODUCTS_PER_PAGE);
		
		LOGGER.info("ProductService | listByCategory | categoryId : " + categoryId);
		LOGGER.info("ProductService | listByCategory | categoryIdMatch : " + categoryIdMatch);
		LOGGER.info("ProductService | listByCategory | pageable : " + pageable);
		

		return repo.listByCategory(categoryId, categoryIdMatch, pageable);
	}

	@Override
	public Product getProduct(String alias) throws ProductNotFoundException {
		// TODO Auto-generated method stub
		return null;
	}

}
