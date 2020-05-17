package com.example.ativiade_06_04_data_jpa.controle;
import com.example.ativiade_06_04_data_jpa.entidade.Aluno;
import com.example.ativiade_06_04_data_jpa.servico.AlunoServico;
import com.example.ativiade_06_04_data_jpa.servico.CursoServico;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class AlunoControle {

    @Autowired
    private AlunoServico alunoServico;

    @Autowired
    private CursoServico cursoServico;

    @GetMapping("/alunos")
    public ModelAndView getAlunos(){
        ModelAndView mv = new ModelAndView("alunosTemplate");
        mv.addObject("aluno", new Aluno());
        mv.addObject("alunos", alunoServico.getAluno());
        mv.addObject("cursos", cursoServico.getCursos());
        return mv;
    }
    
    @PostMapping("/salvarAluno")
    public String salvar(@ModelAttribute Aluno aluno){
        alunoServico.Salvar(aluno);
        return "redirect:/alunos"; // redireciona apos salvar para o template de alunos
                                    // chama o metodo getAlunos acima..
    }
}