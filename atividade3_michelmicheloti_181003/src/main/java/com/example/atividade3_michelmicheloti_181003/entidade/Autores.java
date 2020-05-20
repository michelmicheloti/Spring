package com.example.atividade3_michelmicheloti_181003.entidade;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.UniqueConstraint;

@Entity
public class Autores implements Serializable{

    /**
     *
     */
    private static final long serialVersionUID = 1L;
    
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int codigo;
    private String nome;
    private int idade;
    private String nacionalidade;

    @ManyToMany
    @JoinTable(
        name="LivroAutores",
        uniqueConstraints = @UniqueConstraint(columnNames = {"codigo_livro", "codigo_autor"}),
        joinColumns = @JoinColumn (name = "codigo_autor"),
        inverseJoinColumns = @JoinColumn(name = "codigo_livro")
    )
    private List<Livros> livros;

    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public int getIdade() {
        return idade;
    }

    public void setIdade(int idade) {
        this.idade = idade;
    }

    public String getNacionalidade() {
        return nacionalidade;
    }

    public void setNacionalidade(String nacionalidade) {
        this.nacionalidade = nacionalidade;
    }

    @Override
    public String toString() {
        return "Autores [codigo=" + codigo + ", idade=" + idade + ", nacionalidade=" + nacionalidade + ", nome=" + nome
                + "]";
    }

    public List<Livros> getLivros() {
        return livros;
    }

    public void setLivros(List<Livros> livros) {
        this.livros = livros;
    }
}