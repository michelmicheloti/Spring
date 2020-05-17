package com.example.ativiade_06_04_data_jpa.repository;

import com.example.ativiade_06_04_data_jpa.entidade.Aluno;

import org.springframework.data.jpa.repository.JpaRepository;

/**
 * AlunoRepository
 */
public interface AlunoRepository extends JpaRepository <Aluno, Integer>{

    
}