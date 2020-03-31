package com.example.atividade_23_03.model;

/**
 * Carro
 */
public class Carro {

    private Integer cod;
    private String name;
    private String cor;
    private String dono;
    private Double price;

    public Carro(Integer cod, String name, String cor, String dono, Double price) {
        this.cod = cod;
        this.name = name;
        this.cor = cor;
        this.dono = dono;
        this.price = price;
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

    public String getCor() {
        return cor;
    }

    public void setCor(String cor) {
        this.cor = cor;
    }

    public String getDono() {
        return dono;
    }

    public void setDono(String dono) {
        this.dono = dono;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    @Override
    public String toString() {
        return "Carro [cod=" + cod + ", cor=" + cor + ", dono=" + dono + ", name=" + name + ", price=" + price + "]";
    }
    

    

    
}