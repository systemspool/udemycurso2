package com.jesus.springboot.di.app.springbootdi;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.context.annotation.PropertySource;

import com.jesus.springboot.di.app.springbootdi.repositories.ProductRepository;
import com.jesus.springboot.di.app.springbootdi.repositories.ProductRepositoryJson;

@Configuration
@PropertySource("classpath:config.properties")
public class AppConfig {

    
    //@Primary
    //creamos un metodo para implementar la clase y nos la devuelva con el return
    @Bean("productJson") //para cambiarle el nombre al componente
    ProductRepository productRepositoryJson(){
        return new ProductRepositoryJson();
    }
}
