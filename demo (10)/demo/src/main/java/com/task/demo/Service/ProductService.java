package com.task.demo.Service;

import com.task.demo.Entity.Category;
import com.task.demo.Entity.Product;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;

public interface ProductService {

    public List<Product> getAllProducts();

    public Product getProductById(Long id);

    public Product createProduct(Product product);

    public Product updateProduct(Long id, Product productDetails);

    public void deleteProduct(Long id);

	public Page<Product> findByCategory(Category category, PageRequest pageable);
}
