package com.example.atividade_23_03.controller;

import java.util.ArrayList;

import com.example.atividade_23_03.model.Carro;
import com.example.atividade_23_03.service.CarroService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.servlet.ModelAndView;


/**
 * CarroController
 */
@Controller
public class CarroController {

    @Autowired
    private CarroService cs;

    @GetMapping("/carros")
    public ModelAndView getAllCarro(){
        ModelAndView mv = new ModelAndView("carros");
        ArrayList<Carro> carro = cs.getAllCarro();
        mv.addObject("carro", carro);
        return mv;
    }

    @GetMapping("/carro/{cod}")
    public ModelAndView getCarroById(
        @PathVariable ("cod") int cod
    ){
        ModelAndView mv = new ModelAndView("carroId");
        Carro carro = cs.getCarroById(cod);
        mv.addObject("carro", carro);
        return mv;
    }
    
}