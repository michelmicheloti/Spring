package com.example.ativiade_06_04_data_jpa.controle;

import javax.annotation.PostConstruct;

import com.example.ativiade_06_04_data_jpa.entidade.Aluno;
import com.example.ativiade_06_04_data_jpa.servico.AlunoServico;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class AlunoControle {

    @Autowired
    private AlunoServico servico;

    @GetMapping("/alunos")
    public ModelAndView getAlunos(){
        ModelAndView mv = new ModelAndView("alunosTemplate");
        mv.addObject("alunos", servico.getAluno());
        return mv;
    }
    
    @PostMapping("/salvar")
    public String salvar(@ModelAttribute Aluno aluno){
        servico.Salvar(aluno);
        return "redirect:/alunos"; // redireciona apos salvar para o template de alunos
                                    // chama o metodo getAlunos acima
    }
}