package com.task.demo.repo;

import com.task.demo.Entity.Category;
import com.task.demo.Entity.Product;

import java.awt.print.Pageable;

import org.springframework.data.domain.Page;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductRepo extends JpaRepository<Product,Long> {
	Page<Product> findByCategory(Category category, Pageable pageable);

}
