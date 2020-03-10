package com.webservices.project.services;

import com.webservices.project.entities.Product;
import com.webservices.project.entities.User;
import com.webservices.project.repositories.ProductRepository;
import com.webservices.project.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProductService {
    @Autowired
    private ProductRepository repository;

    public List<Product> findAll(){
        return repository.findAll();
    }

    public Product findById(Long id){
       Optional<Product> obj = repository.findById(id);
       return obj.get();
    }
}
