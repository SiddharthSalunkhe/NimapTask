package com.task.demo.Controller;

import com.task.demo.Entity.Category;
import com.task.demo.Entity.Product;
import com.task.demo.Service.CategoryService;
import org.apache.coyote.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/categories")
public class CategoryControl {

    @Autowired
    private CategoryService cs;


    @PostMapping
    public Category createCategory(@RequestBody Category category) {

        return cs.createCategory(category);
    }

    @GetMapping
    public ResponseEntity<List<Category>> getAllCategories() {
        List<Category> categories = cs.getAllCategories();
        return new ResponseEntity<>(categories, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public Category getCategoryById(@PathVariable(value = "id") Long id) {
        return cs.getCategoryById(id);
    }

    @PutMapping("/{id}")
    public Category updateCategory(@PathVariable(value = "id") Long id, @RequestBody Category categoryDetails) {
        return cs.updateCategory(id, categoryDetails);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteCategory(@PathVariable(value = "id") Long id) {
        cs.deleteCategory(id);
        return ResponseEntity.ok().build();
    }

}
