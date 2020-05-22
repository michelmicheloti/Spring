package com.example.atividade3_michelmicheloti_181003.controle;

import com.example.atividade3_michelmicheloti_181003.entidade.Editoras;
import com.example.atividade3_michelmicheloti_181003.servico.editoraServico;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class EditoraControle {
    @Autowired
    private editoraServico editoraServico;
    
    @GetMapping("/editoras")
    public ModelAndView getEditoras(){
        ModelAndView mv = new ModelAndView("editorasTemplate");
        mv.addObject("editoras", editoraServico.getEditoras());        
        return mv;
    }

    @PostMapping("/salvarEditoras")
    public String salvar(@ModelAttribute Editoras editoras){
        editoraServico.salvar(editoras);
        return "redirect:/editoras";
    }
}