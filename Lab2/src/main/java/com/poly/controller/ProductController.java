package com.poly.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.poly.entity.Product;

@Controller
@RequestMapping("/product")
public class ProductController {
    @GetMapping("/form")
    public String form(Model model) {
        Product p = new Product();
        p.setName("");
        model.addAttribute("product", p);
        return "product/form";
    }

    @PostMapping("/save")
    public String save(Product product, Model model) {
        // Spring sẽ tự bind form -> Product object
        model.addAttribute("product", product);
        return "product/form";
    }
}
