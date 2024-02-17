package com.jesus.springboot.di.app.springbootdi.repositories;

import java.io.IOException;
import java.util.Arrays;
import java.util.List;

import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;

import com.fasterxml.jackson.core.exc.StreamReadException;
import com.fasterxml.jackson.databind.DatabindException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.jesus.springboot.di.app.springbootdi.models.Product;

public class ProductRepositoryJson implements ProductRepository{

    private List<Product> list;

     
    public ProductRepositoryJson(){
        Resource resource= new ClassPathResource("json/product.json");  //para poder leer un json
        ObjectMapper objectMapper = new ObjectMapper();  //el mapper lo como un recurso
        try {
            list = Arrays.asList(objectMapper.readValue(resource.getFile(), Product[].class));  //el resource convierte el archivo json a un tipo file y se pobla el a un arreglo del tipo product y de ahi a una lista
        } catch (StreamReadException e) {
            e.printStackTrace();
        } catch (DatabindException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public List<Product> findAll() {
        return list;
    }

    @Override
    public Product findById(Long id) {
        //retornamos una lista, el filter devuelve un stream de productos, se convierte a un optional con findfirs para obtener el primero. y con orelsethrow devuelve producto
        return list.stream().filter(p-> p.getId().equals(id)).findFirst().orElseThrow(null);
    }

}
