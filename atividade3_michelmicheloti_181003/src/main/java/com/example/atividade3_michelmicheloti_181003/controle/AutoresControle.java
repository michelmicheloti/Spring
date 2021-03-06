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

        mv.addObject("autor",  new Autores());
        mv.addObject("autores", autoresServico.getAutores());
        mv.addObject("livros", livroServico.getLivros());

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
    public ModelAndView getAutorDetalhes(@PathVariable(name = "codigo") Integer codigo) {

        Autores autor = autoresServico.getAutoresById(codigo);
        ModelAndView mv = new ModelAndView("detalhesAutor");
        mv.addObject("autor", autor);
        List <Livros> livrosNaoAssociados = livroServico.getLivros();
        livrosNaoAssociados.removeAll(autor.getLivros());
        mv.addObject("livros", livrosNaoAssociados);

        return mv;
    }

    @GetMapping("/removerAutor")
    public String removerAutor(@RequestParam Integer codigo){
        
        Autores autor = autoresServico.getAutoresById(codigo);
        autoresServico.remover(autor);

        return "redirect:/autores";
    }

    @GetMapping("/editarAutor")
    public ModelAndView editarAutor(@RequestParam Integer codigo){
        
        ModelAndView mv = new ModelAndView("autorEdit");
    
        Autores autor = autoresServico.getAutoresById(codigo);
        mv.addObject("autor",  autor);
        mv.addObject("livros", livroServico.getLivros());

        return mv;
   
    }
}