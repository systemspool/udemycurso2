package com.jesus.springboot.di.app.springbootdi.services;

import java.util.List;

import org.springframework.stereotype.Service;

import com.jesus.springboot.di.app.springbootdi.models.Product;


public interface ProductService {

    List<Product> findAll();

    Product findById(Long id);

}
