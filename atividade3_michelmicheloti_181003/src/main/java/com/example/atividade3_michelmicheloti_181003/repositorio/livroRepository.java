package com.example.atividade3_michelmicheloti_181003.repositorio;

import com.example.atividade3_michelmicheloti_181003.entidade.Livros;

import org.springframework.data.jpa.repository.JpaRepository;

public interface livroRepository extends JpaRepository <Livros,Integer>{
    
}