package com.example.atividade_30_03_form.repository;

import java.util.ArrayList;
import java.util.HashMap;

import com.example.atividade_30_03_form.model.Livro;

import org.springframework.stereotype.Repository;

/**
 * LivroRepository
 */
@Repository
public class LivroRepository {

    private HashMap<Integer, Livro> hm = new HashMap<>();

    public LivroRepository(){
        hm.put(1, new Livro( 1,"Spring", "Autor1", 2 , 20.33));
        hm.put(2, new Livro( 2,"Math", "Autor2", 6 , 50.00));
        hm.put(3, new Livro( 3,"Calc", "Autor3", 5 , 100.00));
        hm.put(4, new Livro( 4,"Java", "Autor4", 1 , 65.12));
        hm.put(5, new Livro( 5,"MVC", "Autor5", 4 , 94.50));
    }

    public HashMap<Integer, Livro> getHashMap(){
        return this.hm;
    }

    public Livro getLivroById(Integer cod){
        return hm.get(cod);
    }

    public ArrayList<Livro> getAllLivro(){
        ArrayList<Livro> list = new ArrayList<>();
        return list;
    }

}