package com.task.demo.Service;

import com.task.demo.Entity.Category;
import com.task.demo.Entity.Product;
import com.task.demo.repo.CategoryRepo;
import com.task.demo.repo.ProductRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AllDao implements CategoryService,ProductService{

    @Autowired
    private CategoryRepo repo;

    @Autowired
    private ProductRepo repo1;

    @Override
    public List<Category> getAllCategories() {
        return repo.findAll();
    }

    @Override
    public Category getCategoryById(Long id) {
        return repo.findById(id).orElseThrow();
    }

    @Override
    public Category createCategory(Category category) {
        return repo.save(category);
    }

    @Override
    public Category updateCategory(Long id, Category categoryDetails) {
        Category category = getCategoryById(id);
        category.setName(categoryDetails.getName());
        return repo.save(categoryDetails);
    }

    @Override
    public void deleteCategory(Long id) {
        Category category = getCategoryById(id);
        repo.delete(category);
    }

    @Override
    public List<Product> getAllProducts() {
        return repo1.findAll();
    }

    @Override
    public Product getProductById(Long id) {
        return repo1.findById(id).orElseThrow();
    }

    @Override
    public Product createProduct(Product product) {
        return repo1.save(product);
    }

    @Override
    public Product updateProduct(Long id, Product productDetails) {
        Product product = getProductById(id);
        product.setName(productDetails.getName());

        product.setPrice(productDetails.getPrice());
        product.setCategory(productDetails.getCategory());
        return repo1.save(product);
    }

    @Override
    public void deleteProduct(Long id) {

        Product product = getProductById(id);
        repo1.delete(product);

    }

	@Override
	public Category findById(Long categoryId) {
		return repo.findById(categoryId).orElseThrow();
	}

	@Override
	public Page<Product> findByCategory(Category category, PageRequest pageable) {
		// TODO Auto-generated method stub
		return null;
	}
}
