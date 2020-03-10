package com.example.atividade1.controller;

import com.example.atividade1.model.Product;
import com.example.atividade1.service.ProductService;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

/**
 * productController
 */
@Controller
@RequestMapping("produto")
public class productController {

    private ProductService productService;

    @GetMapping("/{cod}")
    public ModelAndView getProduct(
        @PathVariable("cod") int cod
    ){
        ModelAndView modelView = new ModelAndView("allProduct");

        Product product = productService.getAllProduct(cod);

        modelView.addObject("allProduct", product);

        return modelView;
    }
    
}