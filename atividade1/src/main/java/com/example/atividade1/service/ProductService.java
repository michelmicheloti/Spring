package com.example.atividade1.service;

import java.util.ArrayList;
import java.util.HashMap;

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

    

    public Product getProductById(Integer cod){
        Product product = productRepository.getProductById(cod);
        if(product != null){
            if(!product.getCod().equals(cod)){
                product = null;
            }
        }
        return product;
    }

    public ArrayList<Product> getAllProduct(){

        ArrayList<Product> list = new ArrayList<Product>();       
        HashMap<Integer, Product> prod = productRepository.getHashMap();

        for(Product p : prod.values()){
            if(p.getStock()>0){
                list.add(p);
            }
        }
        return list;
    }

    public ArrayList<Product> getProductByMoreThanAny(double value){
        ArrayList<Product> list = new ArrayList<>();
        HashMap<Integer, Product> prod = productRepository.getHashMap();

        for(Product p : prod.values()){
            if(p.getValue() > value){
                list.add(p);
            }
        }
        return list;
    }

    public ArrayList<Product> getProductByLessThanAny(double value){
        ArrayList<Product> list = new ArrayList<>();
        HashMap<Integer, Product> prod = productRepository.getHashMap();

        for(Product p : prod.values()){
            if(p.getValue() < value){
                list.add(p);
            }
        }
        return list;
    }
}