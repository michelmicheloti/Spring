package com.example.ativiade_06_04_data_jpa.controle;

import com.example.ativiade_06_04_data_jpa.servico.AlunoServico;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class AlunoControle {

    @Autowired
    private AlunoServico servico;

    @GetMapping("/alunos")
    public ModelAndView getAlunos(){
        ModelAndView mv = new ModelAndView("alunos");
        mv.addObject("alunos", servico.getAluno());
        return mv;
    }
    
    
}