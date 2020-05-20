package com.example.atividade3_michelmicheloti_181003.servico;

import java.util.List;

import com.example.atividade3_michelmicheloti_181003.entidade.Livros;
import com.example.atividade3_michelmicheloti_181003.repositorio.livroRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class livroServico {
    
    @Autowired
    private livroRepository repository;

    public List<Livros> getLivros(){
        return repository.findAll();
    }

    public void salvar(Livros livros){
        repository.save(livros);
    }
}