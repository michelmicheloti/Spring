package com.example.atividade1.controller;

import java.util.ArrayList;

import com.example.atividade1.model.Product;
import com.example.atividade1.service.ProductService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.servlet.ModelAndView;

/**
 * productController
 */
@Controller
public class ProductController {

    @Autowired
    private ProductService productService;

    @GetMapping("/produto/{cod}")
    public ModelAndView getProductById(
        @PathVariable ("cod") int cod
    ){
        ModelAndView mv = new ModelAndView("productById");
        Product product = productService.getProductById(cod);
        mv.addObject("product", product);

        return mv;
    }

    @GetMapping("/produtosEmEstoque")
    public ModelAndView getProduct(){

        ModelAndView modelView = new ModelAndView("allProduct");

        ArrayList<Product> product = productService.getAllProduct();

        modelView.addObject("product", product);

        return modelView;
    }

    @GetMapping("/produtosValorAcima/{value}")
    public ModelAndView getProductByMoreThanAny(
        @PathVariable("value") double valeu
    ){

        ModelAndView modelView = new ModelAndView("productMoreThanAny");

        ArrayList<Product> product = productService.getProductByMoreThanAny(valeu);

        modelView.addObject("product", product);

        return modelView;
    }

    @GetMapping("/produtosValorAcima/{value}")
    public ModelAndView getProductByLessThanAny(
        @PathVariable("value") double valeu
    ){

        ModelAndView modelView = new ModelAndView("productLessThanAny");

        ArrayList<Product> product = productService.getProductByLessThanAny(valeu);

        modelView.addObject("product", product);

        return modelView;
    }
    
}