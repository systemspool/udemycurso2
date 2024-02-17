package com.jesus.springboot.di.app.springbootdi.repositories;

import java.util.List;

import org.springframework.stereotype.Component;

import com.jesus.springboot.di.app.springbootdi.models.Product;

public interface ProductRepository {

    List<Product> findAll();

    Product findById(Long id);

}