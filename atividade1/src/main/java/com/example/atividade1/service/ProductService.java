package com.example.atividade1.service;

import com.example.atividade1.model.Product;
import com.example.atividade1.repository.ProductRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * ProductService
 */
@Service
public class ProductService {

    @Autowired
    private ProductRepository productRepository;

    public Product getAllProduct(Integer cod){
        
        Product product = productRepository.getAllProduct(cod);

        return product;
    }
}