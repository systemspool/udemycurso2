package com.jesus.springboot.di.app.springbootdi.repositories;

import java.util.Arrays;
import java.util.List;

import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import com.jesus.springboot.di.app.springbootdi.models.Product;

@Primary  //para indicar cual es le repositorios principal
@Repository("productList")
public class ProductRepositoryImpl implements ProductRepository{

    private List<Product> data;

    public ProductRepositoryImpl() {
        this.data = Arrays.asList(new Product(1L, "Memoria Corsair 32", 80L),
        new Product(2L, "Procesador Intel core i5", 500L),
        new Product(3L, "Teclado Razer 60%", 180L),
        new Product(4L, "MotherBoard Gigabyte H510", 400L));
    }

    //metodo que devuelve toda la lista
    @Override
    public List<Product> findAll(){
        return data;
    }

    //metodo que mediante un strem hace la comparacion del id buscado y devuelve el primer objeto encontrado por el id pasado como parametro
    @Override
    public Product findById(Long id){
        return data.stream().filter(p -> p.getId().equals(id)).findFirst().orElse(null);
    }

    

    
}
