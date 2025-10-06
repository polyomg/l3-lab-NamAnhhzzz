package com.poly.controller;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.poly.entity.Product;

@Controller
public class Bai4 {
	
	@GetMapping("/product/form2")
	public String form(Model model) {
        Product p1 = new Product();
        p1.setName("iPhone 30");
        p1.setPrice(5000.0);
        model.addAttribute("p1", p1);
        model.addAttribute("p2", new Product());
        model.addAttribute("items", items);
        return "product/form2";
    }

    @PostMapping("/product/save2")
    public String save(@ModelAttribute("p2") Product p, Model model) {
        Product p1 = new Product("iPhone 30", 5000.0);
        model.addAttribute("p1", p1);
        model.addAttribute("p2", p);
        items.add(p);
        model.addAttribute("items", items);

        return "product/form2";
    }

    // ?3: tạo danh sách sản phẩm
    private List<Product> items = new ArrayList<>(Arrays.asList(
            new Product("iPhone 15", 25000.0),
            new Product("Samsung S24", 22000.0),
            new Product("Xiaomi 14", 15000.0),
            new Product("Oppo Find X7", 18000.0),
            new Product("Vivo X100", 16000.0),
            new Product("Realme GT 6", 12000.0),
            new Product("MacBook Pro", 40000.0),
            new Product("Dell XPS 13", 35000.0),
            new Product("Asus ROG", 45000.0),
            new Product("HP Spectre", 30000.0),
            new Product("iPad Pro", 28000.0),
            new Product("Galaxy Tab S9", 24000.0),
            new Product("Apple Watch 9", 12000.0),
            new Product("Samsung Galaxy Watch 6", 10000.0),
            new Product("AirPods Pro", 6000.0),
            new Product("Sony WH-1000XM5", 8000.0),
            new Product("Logitech MX Master 3S", 3000.0),
            new Product("Razer BlackWidow", 5000.0),
            new Product("Canon EOS R6", 60000.0),
            new Product("Nikon Z6 II", 55000.0)
        ));
}
