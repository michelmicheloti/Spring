package com.example.atividade_30_03_form.controller;

import java.util.ArrayList;

import com.example.atividade_30_03_form.model.Livro;
import com.example.atividade_30_03_form.service.LivroService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

/**
 * LivroController
 */
@Controller
public class LivroController {

    @Autowired
    private LivroService ls;

    @GetMapping("/pesquisaLivro")
    public String pesquisaLivro(){
        return "livro";
    }

    @PostMapping("/pesquisaLivro")
    public ModelAndView livroForm(@ModelAttribute Livro livro){
        ModelAndView mv = new ModelAndView();
        livro = ls.getLivroById(livro.getCod());

        if(livro == null){
            mv.setViewName("erro");
        }else{
            mv.setViewName("livroView");
        }

        mv.addObject("livro", livro);
        return mv;
    }

    @GetMapping("/livros")
    public ModelAndView getAllLivros(){
        ModelAndView mv = new ModelAndView("livros");
        ArrayList<Livro> livro = ls.getAllLivros();
        mv.addObject("livro", livro);
        return mv;
    }

}