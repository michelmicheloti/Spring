package com.example.ativiade_06_04_data_jpa.servico;

import java.util.List;

import com.example.ativiade_06_04_data_jpa.entidade.Professor;
import com.example.ativiade_06_04_data_jpa.repository.ProfessorRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProfessoreServico {
    
    @Autowired
    private ProfessorRepository repository;

    public List<Professor> getProfessores(){
        return repository.findAll();
    }

    public void Salvar(Professor professor){
        repository.save(professor);
    }

    public Professor getProfessorById(int id){
        return repository.findById(id).get();
    }
}