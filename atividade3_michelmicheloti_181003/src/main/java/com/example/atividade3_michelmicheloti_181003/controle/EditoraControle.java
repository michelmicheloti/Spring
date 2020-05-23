package com.example.atividade3_michelmicheloti_181003.controle;

import java.util.List;

import com.example.atividade3_michelmicheloti_181003.entidade.Editoras;
import com.example.atividade3_michelmicheloti_181003.entidade.Livros;
import com.example.atividade3_michelmicheloti_181003.servico.editoraServico;
import com.example.atividade3_michelmicheloti_181003.servico.livroServico;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jca.cci.object.EisOperation;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class EditoraControle {
    @Autowired
    private editoraServico editoraServico;

    @Autowired
    private livroServico livroServico;
    
    @GetMapping("/editoras")
    public ModelAndView getEditoras(){
        ModelAndView mv = new ModelAndView("editorasTemplate");

        mv.addObject("editora", new Editoras());
        mv.addObject("editoras", editoraServico.getEditoras());   
        mv.addObject("livros", livroServico.getLivros());
             
        return mv;
    }

    @PostMapping("/salvarEditoras")
    public String salvar(@ModelAttribute Editoras editoras){
        editoraServico.salvar(editoras);
        return "redirect:/editoras";
    }

    
    @PostMapping("/associarLivroEditora")
    public String associarLivro(@ModelAttribute Livros livro, @RequestParam Integer codigoEditora) {
        

        Editoras editoras = editoraServico.getEditorasById(codigoEditora);
        livro = livroServico.getLivrosById(livro.getCodigo());
        

        editoras.getLivros().add(livro);
        editoraServico.salvar(editoras);

        return "redirect:/detalhesEditora/" + codigoEditora;
    }

    @GetMapping("/detalhesEditora/{codigo}")
    public ModelAndView getEditoraDetalhes(@PathVariable(name = "codigo") Integer codigo) {

        Editoras editora = editoraServico.getEditorasById(codigo);
        ModelAndView mv = new ModelAndView("detalhesEditora");
        mv.addObject("editora", editora);
        
        List <Livros> livrosNaoAssociados = livroServico.getLivros();
        livrosNaoAssociados.removeAll(editora.getLivros());
        mv.addObject("livros", livrosNaoAssociados);

        return mv;
    }

    @GetMapping("/removerEditora")
    public String removerEditora(@RequestParam Integer codigo){
        
        Editoras editora = editoraServico.getEditorasById(codigo);
        editoraServico.remover(editora);

        return "redirect:/editoras";
    }

    @GetMapping("/editarEditora")
    public ModelAndView editarEditora(@RequestParam Integer codigo){
        
        ModelAndView mv = new ModelAndView("editoraEdit");
    
        Editoras editoras = editoraServico.getEditorasById(codigo);
        mv.addObject("editora",  editoras);

        return mv;
   
    }
}