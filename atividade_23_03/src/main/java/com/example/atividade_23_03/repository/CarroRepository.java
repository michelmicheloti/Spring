package com.example.atividade_23_03.repository;

import java.util.ArrayList;
import java.util.HashMap;

import com.example.atividade_23_03.model.Carro;

import org.springframework.stereotype.Repository;

/**
 * CarroRepository
 */
@Repository
public class CarroRepository {

    private HashMap<Integer, Carro> hm = new HashMap<>();

    public CarroRepository() {
        hm.put(1, new Carro(1, "c1", "branco" , "joao", 2.0));
        hm.put(2, new Carro(2, "c2", "vermelho" , "maria", 4.0));
        hm.put(3, new Carro(3, "c3", "azul" , "ana", 3.0));
        hm.put(4, new Carro(4, "c4", "amarelo" , "paulo", 22.0));
        hm.put(5, new Carro(5, "c5", "preto" , "luiz", 1.0));
    }

    public HashMap <Integer, Carro> getHashMap(){
        return this.hm;
    }

    public Carro getCarroById(Integer cod){
        return hm.get(cod);
    }

    public ArrayList<Carro> getAllCarro(){
        ArrayList<Carro> list = new ArrayList<>();
        return list;
    }
    
}