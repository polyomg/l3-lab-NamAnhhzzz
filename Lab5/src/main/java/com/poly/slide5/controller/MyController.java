package com.poly.slide5.controller;


import jakarta.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.poly.slide5.service.CookieService;
import com.poly.slide5.service.CookieService2;

//@Controller
public class MyController {
	//@Autowired
    //HttpServletRequest request;

    //@Autowired
    //CookieService cookieService;

    //@Autowired
    //CookieService2 cookieService2;// = new CookieService2() ;

    //@RequestMapping("/my-url")
    //public String method(Model model) {
        //String uri = request.getParameter("fullname");

        //String upcaseFullname = uri.toUpperCase();
        //cookieService.create("name","Poly" + upcaseFullname,60);
        //model.addAttribute("fullname", upcaseFullname);
        //return "/demo/page";
    //}

    //@GetMapping("/my-url-get")
    //public String methodGet(Model model) {
        //String getcookie = cookieService.getValue("name");

        //model.addAttribute("fullname", getcookie + " - Get - " + cookieService.getNum().toString());
        //return "/demo/page";
    //}

}
