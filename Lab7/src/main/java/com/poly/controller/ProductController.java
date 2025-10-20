package com.poly.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.poly.dao.ProductDAO;
import com.poly.entity.Product;

@Controller
public class ProductController {
	
	@Autowired
    ProductDAO dao;

    @RequestMapping("/product/search")
    public String search(Model model,
        @RequestParam("min") Optional<Double> min,
        @RequestParam("max") Optional<Double> max) {

        // Nếu không nhập thì dùng giá trị mặc định
        double minPrice = min.orElse(Double.MIN_VALUE);
        double maxPrice = max.orElse(Double.MAX_VALUE);

        List<Product> items = dao.findByPrice(minPrice, maxPrice);
        model.addAttribute("items", items);
        model.addAttribute("minValue", min.orElse(null));
        model.addAttribute("maxValue", max.orElse(null));
        return "product/search";
    }

}
