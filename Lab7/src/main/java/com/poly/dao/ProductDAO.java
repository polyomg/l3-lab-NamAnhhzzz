package com.poly.dao;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;//bat buoc dung de duoc truy van query
import org.springframework.data.repository.query.Param;

import com.poly.entity.Product;
import com.poly.entity.Report;

public interface ProductDAO extends JpaRepository<Product, Integer> {
    // === Bài 1: Tìm theo khoảng giá ===
	@Query("SELECT p FROM Product p WHERE p.price BETWEEN ?1 AND ?2")
	List<Product> findByPrice(double minPrice, double maxPrice);
	
    // === Bài 2: Tìm theo từ khóa + phân trang ===
    @Query("SELECT p FROM Product p WHERE p.name LIKE :keywords")
    Page<Product> findByKeywords(String keywords, Pageable pageable);
    
 // === Bài 3:  tổng hợp dữ liệu tồn kho ===
    @Query("SELECT p.category.name AS group, SUM(p.price) AS sum, COUNT(p) AS count "
    	     + "FROM Product p "
    	     + "GROUP BY p.category.name "
    	     + "ORDER BY SUM(p.price) DESC")
    	List<Report> getInventoryByCategory();
    
    // === Bài 4: Tìm theo khoảng giá sử dụng DSL ===
	List<Product> findByPriceBetween(double minPrice, double maxPrice);
	
	// === Bài 5: Tìm theo từ khóa + phân trang sử dụng DSL ===
	Page<Product> findAllByNameLike(String keywords, Pageable pageable); 
}
