package com.poly.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
public class Bai5 {
	
	@RequestMapping("/a")
    public String m1() {
        return "poly/a"; // view a.html
    }

    @RequestMapping("/b")
    public String m2(Model model) {
        model.addAttribute("message", "I come from b");
        return "poly/a"; // F1: quay lại view a.html, message lấy từ Model
    }

    @RequestMapping("/c")
    public String m3(RedirectAttributes params) {
        params.addAttribute("message", "I come from c");
        return "redirect:/a"; // F2: redirect về /a, message lấy từ RedirectAttributes
    }

    @RequestMapping("/d")
    @ResponseBody 
    public String m4() {
        return "I come from d"; // F3: trả về chuỗi trực tiếp
    }

}
