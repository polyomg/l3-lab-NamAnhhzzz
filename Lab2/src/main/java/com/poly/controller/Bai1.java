package com.poly.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/ctrl")
public class Bai1 {
	// OK 1: POST -> gọi m1()
    @PostMapping("/ok")
    public String m1(Model model) {
        model.addAttribute("message", "Đã gọi m1()");
        return "poly/ok";
    }

    // OK 2: GET -> gọi m2()
    @GetMapping("/ok")
    public String m2(Model model) {
        model.addAttribute("message", "Đã gọi m2()");
        return "poly/ok";
    }

    @RequestMapping(value = "/ok", params = "x")
    public String m3(Model model) {
        model.addAttribute("message", "Đã gọi m3()");
        return "poly/ok";
    }

}
