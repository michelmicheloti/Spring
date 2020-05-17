package com.example.ativiade_06_04_data_jpa.repository;

import com.example.ativiade_06_04_data_jpa.entidade.Curso;

import org.springframework.data.jpa.repository.JpaRepository;

public interface CursoRepository extends JpaRepository <Curso,Integer>{
    
}