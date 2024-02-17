package com.jesus.springboot.di.app.springbootdi.services;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import com.jesus.springboot.di.app.springbootdi.models.Product;
import com.jesus.springboot.di.app.springbootdi.repositories.ProductRepository;


@Service
public class ProductServiceImpl implements ProductService{


    @Autowired
    @Qualifier("productJson") //para indicar que componente se inyecta
    private ProductRepository productRepository;

    @Autowired
    private Environment environment;

    

    /*public ProductServiceImpl(@Qualifier("productFoo") ProductRepository productRepository) {
        this.productRepository = productRepository;
    }*/

    //devolvemos una lista de precios agregandole un impuesto
    @Override
    public List<Product> findAll(){
        return productRepository.findAll().stream().map(p -> {
            Double priceTax = p.getPrice()*environment.getProperty("config.price.tax", Double.class);
            //product newProduct = new product(p.getId(), p.getName(), priceImp.longValue());
            
            Product newProduct = (Product) p.clone();
            newProduct.setPrice(priceTax.longValue());
            return newProduct;
           
            //p.setPrice(priceTax.longValue());
            //return p;
           
        }).collect(Collectors.toList());
    }
    
    @Override
    public Product findById(Long id){
        return productRepository.findById(id);
    }


}
