package com.task.demo.Service;

import com.task.demo.Entity.Category;

import java.util.List;

public interface CategoryService {

    public List<Category> getAllCategories();

    public Category getCategoryById(Long id);

    public Category createCategory(Category category);

    public Category updateCategory(Long id, Category categoryDetails);

    public void deleteCategory(Long id);

	public Category findById(Long categoryId);
}
