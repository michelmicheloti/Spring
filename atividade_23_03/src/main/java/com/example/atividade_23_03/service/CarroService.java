package com.example.atividade_23_03.service;

import java.util.ArrayList;
import java.util.HashMap;

import com.example.atividade_23_03.model.Carro;
import com.example.atividade_23_03.repository.CarroRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * CarroService
 */
@Service
public class CarroService {

    @Autowired
    private CarroRepository cr;

    public Carro getCarroById(Integer cod){
        Carro carro = cr.getCarroById(cod);
        if(carro == null){
            carro = null;
        }        
        return carro;
    }

    public ArrayList<Carro> getAllCarro(){
        ArrayList<Carro> list = new ArrayList<>();
        HashMap<Integer, Carro> car = cr.getHashMap();

        for(Carro c: car.values()){
            list.add(c);
        }
        return list;
    }
}