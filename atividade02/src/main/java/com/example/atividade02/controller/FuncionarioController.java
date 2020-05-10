package com.example.atividade02.controller;

import com.example.atividade02.entidade.Funcionario;
import com.example.atividade02.service.FuncionarioService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class FuncionarioController {

    @Autowired
    private FuncionarioService servico;

    @GetMapping("/funcionarios")
    public ModelAndView getFuncionario(){
        ModelAndView mv = new ModelAndView("funcionarioTemplate");
        mv.addObject("funcionario", servico.getFuncionario());

        return mv;
    }

    @PostMapping("/salvar")
    public String salvar(@ModelAttribute Funcionario func){
        servico.salvar(func);
        return "funcionarioTemplate";
    }
}