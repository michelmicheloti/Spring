package com.example.ativiade_06_04_data_jpa.controle;

import com.example.ativiade_06_04_data_jpa.entidade.Curso;
import com.example.ativiade_06_04_data_jpa.servico.CursoServico;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class CursoControle {
    
    @Autowired
    private CursoServico servico;

    @GetMapping("/cursos")
    public ModelAndView getCursos(){
        ModelAndView mv = new ModelAndView("cursosTemplate");
        mv.addObject("cursos", servico.getCursos());
        return mv;
    }

    @GetMapping("/detalhesCurso/{id}")
    public ModelAndView getCursoDetalhes(@PathVariable(name = "id") Integer id){
        Curso curso = servico.getCursoByid(id);
        ModelAndView mv = new ModelAndView("detalhesCurso");
        mv.addObject("curso", curso);
        return mv;
    }

    @PostMapping("/salvarCursos")
    public String Salvar(@ModelAttribute Curso curso){
        servico.Salvar(curso);
        return "redirect:/cursos";
    }
}