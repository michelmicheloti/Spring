package com.example.atividade3_michelmicheloti_181003.repositorio;

import com.example.atividade3_michelmicheloti_181003.entidade.Autores;

import org.springframework.data.jpa.repository.JpaRepository;

public interface autorRepository extends JpaRepository <Autores, Integer>{
    
}