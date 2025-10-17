package com.poly.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.poly.bean.Staff;

@Controller
public class Bai1 {
	
	@RequestMapping("/staff/detail") 
	public String detail(Model model) { 
	Staff staff = Staff.builder() 
	.id("user@gmail.com") 
	.fullname("nguyễn văn user") 
	.level(2) 
	.build(); 
	model.addAttribute("staff", staff); 
	return "/poly/staff-detail"; 
	} 
}
