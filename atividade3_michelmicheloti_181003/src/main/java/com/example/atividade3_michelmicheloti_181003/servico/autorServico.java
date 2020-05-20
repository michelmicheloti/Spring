package com.example.atividade3_michelmicheloti_181003.servico;

import java.util.List;

import com.example.atividade3_michelmicheloti_181003.entidade.Autores;
import com.example.atividade3_michelmicheloti_181003.repositorio.autorRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class autorServico {

    @Autowired
    private autorRepository repository;

    public List<Autores> getAutores(){
        return repository.findAll();
    }

    public void salvar(Autores autores){
        repository.save(autores);
    }
}