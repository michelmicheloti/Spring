package com.example.atividade3_michelmicheloti_181003.servico;

import java.util.List;

import com.example.atividade3_michelmicheloti_181003.entidade.Editoras;
import com.example.atividade3_michelmicheloti_181003.repositorio.editoraRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class editoraServico {
    
    @Autowired
    private editoraRepository repository;

    public List<Editoras> getEditoras(){
        return repository.findAll();
    }

    public void salvar(Editoras editoras){
        repository.save(editoras);
    }

    public Editoras getEditorasById(int codigo){
        return repository.findById(codigo).get();
    }

    public void remover(Editoras editoras){
        repository.delete(editoras);
    }
}