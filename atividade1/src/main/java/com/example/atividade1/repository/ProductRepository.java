package com.example.atividade1.repository;

import java.util.HashMap;

import com.example.atividade1.model.Product;

import org.springframework.stereotype.Repository;

/**
 * ProductRepository
 */
@Repository
public class ProductRepository {

    public HashMap<Integer, Product> hm = new HashMap<>();

    public ProductRepository(){
        hm.put(1, new Product(1, "name", 10.0, 2));
    }

    public Product getAllProduct(Integer cod){
        return hm.get(cod);
    }
    
}