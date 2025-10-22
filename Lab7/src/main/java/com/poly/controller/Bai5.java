package com.poly.controller;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.poly.dao.ProductDAO;
import com.poly.entity.Product;
import com.poly.service.SessionService;

@Controller
public class Bai5 {
	
	@Autowired
    ProductDAO dao;

    @Autowired
    SessionService session;

    @RequestMapping("/product/search-and-page2")
    public String searchAndPage(
            Model model,
            @RequestParam("keywords") Optional<String> kw,
            @RequestParam("p") Optional<Integer> p) {

        // Lấy từ khoá từ session nếu không nhập mới
        String keywords = kw.orElse(session.get("keywords", ""));
        session.set("keywords", keywords);

        // Thiết lập phân trang (trang hiện tại và kích thước)
        PageRequest pageable = PageRequest.of(p.orElse(0), 5);

        // Gọi DAO tìm kiếm (có dấu %)
        Page<Product> page = dao.findAllByNameLike("%" + keywords + "%", pageable);

        model.addAttribute("page", page);
        model.addAttribute("keywords", keywords);
        return "product/search-and-page";
    }

}
