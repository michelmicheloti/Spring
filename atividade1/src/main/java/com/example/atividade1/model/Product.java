package com.example.atividade1.model;

/**
 * Product
 */
public class Product {

    private Integer cod;
    private String name;
    private Double value;
    private Integer stock;

    public Product(Integer cod, String name, Double value, Integer stock) {
        this.cod = cod;
        this.name = name;
        this.value = value;
        this.stock = stock;
    }

    public Integer getCod() {
        return cod;
    }

    public void setCod(Integer cod) {
        this.cod = cod;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Double getValue() {
        return value;
    }

    public void setValue(Double value) {
        this.value = value;
    }

    public Integer getStock() {
        return stock;
    }

    public void setStock(Integer stock) {
        this.stock = stock;
    }

    @Override
    public String toString() {
        return "Product [cod=" + cod + ", name=" + name + ", stock=" + stock + ", value=" + value + "]";
    } 
    
}