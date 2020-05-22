package com.example.atividade3_michelmicheloti_181003.controle;

import com.example.atividade3_michelmicheloti_181003.entidade.Livros;
import com.example.atividade3_michelmicheloti_181003.servico.livroServico;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class LivroControle {
    
    @Autowired
    private livroServico servico;

    @GetMapping("/livros")
    public ModelAndView getCursos() {
        ModelAndView mv = new ModelAndView("cursosTemplate");
        mv.addObject("livros", servico.getLivros());

        return mv;
    }

    @GetMapping("/detalhesLivro/{id}")
    public ModelAndView getCursoDetalhes(@PathVariable(name = "id") Integer id) {
        
        Livros livros = servico.getLivrosById(id);
        ModelAndView mv = new ModelAndView("detalhesLivro");
        mv.addObject("livro", livros);

        return mv;
    }

    @PostMapping("/salvarLivro")
    public String salvar(@ModelAttribute Livros livro) {
        servico.salvar(livro);
        return "redirect:/livros";
    }

}