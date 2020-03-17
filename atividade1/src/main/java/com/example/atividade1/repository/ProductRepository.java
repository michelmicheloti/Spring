package com.example.atividade1.repository;

import java.util.ArrayList;
import java.util.HashMap;

import com.example.atividade1.model.Product;

import org.springframework.stereotype.Repository;

/**
 * ProductRepository
 */
@Repository
public class ProductRepository {

    private HashMap<Integer, Product> hm = new HashMap<>();

    public ProductRepository(){
        hm.put(1, new Product(1, "Oculos", 102.0, 4));
        hm.put(2, new Product(2, "Garrafa", 13.0, 20));
        hm.put(3, new Product(1, "Vidro", 34.0, 22));
        hm.put(4, new Product(2, "Telefone", 23.0, 3));
        hm.put(5, new Product(1, "Pc", 1044.0, 2));
        hm.put(6, new Product(2, "Mouse", 21.0, 230));
        hm.put(7, new Product(1, "Cadeira", 140.0, 43));
        hm.put(8, new Product(2, "Mesa", 4341.0, 54));
        hm.put(9, new Product(1, "Monitor", 1220.0, 222));
        hm.put(10, new Product(2, "Banana", 1.0, 204));
    } 
    
    public HashMap <Integer, Product> getHashMap(){
        return this.hm;
    }

    public Product getProductById(Integer cod){
        return hm.get(1);
    }
    
    
    public ArrayList<Product> getAllProduct(){
        ArrayList<Product> list = new ArrayList<>();
        return list;
    }
}