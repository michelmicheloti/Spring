package com.example.ativiade_06_04_data_jpa.controle;

import java.util.List;

import com.example.ativiade_06_04_data_jpa.entidade.Curso;
import com.example.ativiade_06_04_data_jpa.entidade.Professor;
import com.example.ativiade_06_04_data_jpa.servico.CursoServico;
import com.example.ativiade_06_04_data_jpa.servico.ProfessorServico;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class ProfessorControle {
    
    @Autowired
    private ProfessorServico professorServico;

    @Autowired
    private CursoServico cursoServico;

    @GetMapping("/professores")
    public ModelAndView getProfessores() {
        ModelAndView mv = new ModelAndView("professoresTemplate");
        mv.addObject("professores", professorServico.getProfessores());

        return mv;
    }

    @PostMapping("/salvarProfessor")
    public String salvar(@ModelAttribute Professor professor) {
        professorServico.Salvar(professor);
        return "redirect:/professores";
    }

    @PostMapping("/associarCursoProfessor")
    public String associarCurso(@ModelAttribute Curso curso, @RequestParam Integer codigoProfessor) {
        

        Professor professor = professorServico.getProfessorById(codigoProfessor);
        curso = cursoServico.getCursoByid(curso.getId());
        

        professor.getCursos().add(curso);
        professorServico.Salvar(professor);

        return "redirect:/detalhesProfessor/" + codigoProfessor;
    }

    @GetMapping("/detalhesProfessor/{codigo}")
    public ModelAndView getCursoDetalhes(@PathVariable(name = "codigo") Integer codigo) {

        Professor professor = professorServico.getProfessorById(codigo);
        ModelAndView mv = new ModelAndView("detalhesProfessor");
        mv.addObject("professor", professor);
        List <Curso> cursosNaoAssociados = cursoServico.getCursos();
        cursosNaoAssociados.removeAll(professor.getCursos());
        mv.addObject("cursos", cursosNaoAssociados);

        return mv;
    }
}