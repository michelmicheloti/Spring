package com.example.atividade3_michelmicheloti_181003.controle;

import java.util.List;

import com.example.atividade3_michelmicheloti_181003.entidade.Autores;
import com.example.atividade3_michelmicheloti_181003.entidade.Livros;
import com.example.atividade3_michelmicheloti_181003.servico.autorServico;
import com.example.atividade3_michelmicheloti_181003.servico.livroServico;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class AutoresControle {
    @Autowired
    private autorServico autoresServico;

    @Autowired
    private livroServico livroServico;

    @GetMapping("/autores")
    public ModelAndView getProfessores() {
        ModelAndView mv = new ModelAndView("autoresTemplate");
        mv.addObject("autores", autoresServico.getAutores());

        return mv;
    }

    @PostMapping("/salvarAutor")
    public String salvar(@ModelAttribute Autores autores) {
        autoresServico.salvar(autores);
        return "redirect:/autores";
    }

    @PostMapping("/associarLivroAutor")
    public String associarLivro(@ModelAttribute Livros livro, @RequestParam Integer codigoAutor) {
        

        Autores autores = autoresServico.getAutoresById(codigoAutor);
        livro = livroServico.getLivrosById(livro.getCodigo());
        

        autores.getLivros().add(livro);
        autoresServico.salvar(autores);

        return "redirect:/detalhesAutor/" + codigoAutor;
    }

    @GetMapping("/detalhesAutor/{codigo}")
    public ModelAndView getCursoDetalhes(@PathVariable(name = "codigo") Integer codigo) {

        Autores autor = autoresServico.getAutoresById(codigo);
        ModelAndView mv = new ModelAndView("detalhesAutor");
        mv.addObject("autor", autor);
        List <Livros> livrosNaoAssociados = livroServico.getLivros();
        livrosNaoAssociados.removeAll(autor.getLivros());
        mv.addObject("livros", livrosNaoAssociados);

        return mv;
    }
}