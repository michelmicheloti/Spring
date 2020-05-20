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
import javax.persistence.ManyToOne;
import javax.persistence.UniqueConstraint;

@Entity
public class Livros implements Serializable{

    /**
     *
     */
    private static final long serialVersionUID = 1L;
    
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int codigo;
    private String nome;
    private int edicao;
    private String genero;

    @ManyToOne
    @JoinColumn(name = "ID_EDITORA")
    private Editoras editoras;

    
    @ManyToMany
    @JoinTable(
        name="LivroAutores",
        uniqueConstraints = @UniqueConstraint (columnNames = {"codigo_livro", "codigo_autor"}),
        joinColumns = @JoinColumn(name = "codigo_livro"),
        inverseJoinColumns = @JoinColumn(name = "codigo_autor")
    )
    private List<Autores> autores;

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

    public int getEdicao() {
        return edicao;
    }

    public void setEdicao(int edicao) {
        this.edicao = edicao;
    }

    public String getGenero() {
        return genero;
    }

    public void setGenero(String genero) {
        this.genero = genero;
    }

    public Editoras getEditoras() {
        return editoras;
    }

    public void setEditoras(Editoras editoras) {
        this.editoras = editoras;
    }

    @Override
    public String toString() {
        return "Livros [codigo=" + codigo + ", edicao=" + edicao + ", editoras=" + editoras.getNome() + ", genero=" + genero
                + ", nome=" + nome + "]";
    }

    public List<Autores> getAutores() {
        return autores;
    }

    public void setAutores(List<Autores> autores) {
        this.autores = autores;
    }
}