package com.poly.controller;

import java.util.List;
import java.util.Optional; // Cần import
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort; // Cần import
import org.springframework.data.domain.Sort.Direction; // Cần import
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam; // Cần import
import org.springframework.data.domain.Page; // Cần import
import org.springframework.data.domain.PageRequest; // Cần import
import org.springframework.data.domain.Pageable;

import com.poly.dao.ProductDAO;
import com.poly.entity.Product;

@Controller
public class ProductController {

    @Autowired
    ProductDAO dao;
    
    // Bài 3: Phương thức xử lý Sắp xếp
    @RequestMapping("/product/sort")
    public String sort(Model model, 
                       @RequestParam("field") Optional<String> field) {
        
        // 1. Xác định cột sắp xếp: mặc định là "price" nếu không có tham số field [cite: 309, 315]
        // 2. Tạo đối tượng Sort: Sắp xếp GIẢM DẦN (Direction.DESC) theo cột đã chọn [cite: 310]
        Sort sort = Sort.by(Direction.DESC, field.orElse("price"));
        
        // 3. Truy vấn tất cả sản phẩm, có áp dụng sắp xếp [cite: 312, 316]
        List<Product> items = dao.findAll(sort);
        model.addAttribute("items", items);
        
        // 4. Thêm tên cột hiện tại vào Model để hiển thị trên tiêu đề [cite: 311]
        model.addAttribute("field", field.orElse("price").toUpperCase());
        
        return "product/sort";
    }
    @RequestMapping("/product/page")
    public String paginate(Model model,
                           @RequestParam("p") Optional<Integer> p) {
        
        // 1. Khởi tạo Pageable: p.orElse(0) là số trang (mặc định là 0), 5 là kích thước trang
        Pageable pageable = PageRequest.of(p.orElse(0), 5);
        
        // 2. Truy vấn dữ liệu: dao.findAll(pageable) trả về đối tượng Page<Product>
        Page<Product> page = dao.findAll(pageable);
        
        // 3. Thêm đối tượng Page vào Model
        model.addAttribute("page", page);
        
        return "product/page";
    }
}