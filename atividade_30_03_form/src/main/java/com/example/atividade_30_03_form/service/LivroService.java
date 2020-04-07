package com.example.atividade_30_03_form.service;

import java.util.ArrayList;
import java.util.HashMap;

import com.example.atividade_30_03_form.model.Livro;
import com.example.atividade_30_03_form.repository.LivroRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * LivroService
 */
@Service
public class LivroService {

    @Autowired
    private LivroRepository lr;

    public Livro getLivroById(Integer cod){
        Livro livro = lr.getLivroById(cod);
        if(livro == null){
            livro = null;
        }
        return livro;
    }
    
    public ArrayList<Livro> getAllLivros(){
        ArrayList<Livro> list = new ArrayList<>();
        HashMap<Integer, Livro> livro = lr.getHashMap();

        for(Livro l: livro.values()){
            list.add(l);
        }
        return list;
    }

}