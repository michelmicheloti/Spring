package com.example.atividade_30_03_form.model;

/**
 * Livro
 */
public class Livro {

    private Integer cod;
    private String name;
    private String actor;
    private Integer edition;
    private Double price;

    public Livro() {
    }
    
    public Livro(Integer cod, String name, String actor, Integer edition, Double price) {
        this.cod = cod;
        this.name = name;
        this.actor = actor;
        this.edition = edition;
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

    public String getActor() {
        return actor;
    }

    public void setActor(String actor) {
        this.actor = actor;
    }

    public Integer getEdition() {
        return edition;
    }

    public void setEdition(Integer edition) {
        this.edition = edition;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    @Override
    public String toString() {
        return "Livro [actor=" + actor + ", cod=" + cod + ", edition=" + edition + ", name=" + name + ", price=" + price
                + "]";
    }

    
    

}