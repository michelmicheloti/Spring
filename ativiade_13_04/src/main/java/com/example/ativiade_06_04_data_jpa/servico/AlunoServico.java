package com.example.ativiade_06_04_data_jpa.servico;

import java.util.List;

import com.example.ativiade_06_04_data_jpa.entidade.Aluno;
import com.example.ativiade_06_04_data_jpa.repository.AlunoRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AlunoServico {

    @Autowired
    private AlunoRepository repository;

    public List<Aluno> getAluno(){
        return repository.findAll();
    }

    public void Salvar(Aluno aluno){
        repository.save(aluno);
    }
}