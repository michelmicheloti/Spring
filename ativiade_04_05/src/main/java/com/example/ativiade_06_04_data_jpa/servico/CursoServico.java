package com.example.ativiade_06_04_data_jpa.servico;

import java.util.List;

import com.example.ativiade_06_04_data_jpa.entidade.Curso;
import com.example.ativiade_06_04_data_jpa.repository.CursoRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CursoServico {
    
    @Autowired
    private CursoRepository repository;

    public List<Curso> getCursos(){
        return repository.findAll();
    }

    public void Salvar(Curso curso){
        repository.save(curso);
    }

    public Curso getCursoByid(int id){
        return repository.findById(id).get();
    }
}