package com.poly.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import com.poly.entity.Category;

// T là Category, ID là String
public interface CategoryDAO extends JpaRepository<Category, String>{}