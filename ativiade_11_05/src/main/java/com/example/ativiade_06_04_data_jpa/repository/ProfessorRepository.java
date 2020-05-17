package com.example.ativiade_06_04_data_jpa.repository;

import com.example.ativiade_06_04_data_jpa.entidade.Professor;

import org.springframework.data.jpa.repository.JpaRepository;

public interface ProfessorRepository extends JpaRepository <Professor,Integer>{
    
}