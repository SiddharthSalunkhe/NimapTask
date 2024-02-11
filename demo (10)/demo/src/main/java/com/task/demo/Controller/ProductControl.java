package com.task.demo.Controller;

import com.task.demo.Entity.Category;
import com.task.demo.Entity.Product;
import com.task.demo.Service.CategoryService;
import com.task.demo.Service.ProductService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/products")
public class ProductControl {

    @Autowired
    private CategoryService cs;

    @Autowired
    private ProductService ps;

    private static final Logger log = LoggerFactory.getLogger(ProductControl.class);

    @PostMapping("createProduct")
    public Product createProduct(@RequestBody Product product) {
        if (product.getCategory() != null && product.getCategory().getId() == null) {
            cs.createCategory(product.getCategory());
        }
        Product product1 =ps.createProduct(product);
        return product1;
    }

    @GetMapping("getAll")
    public ResponseEntity<List<Product>> getAllProducts() {
        try {
            List<Product> products = ps.getAllProducts();
            return new ResponseEntity<>(products, HttpStatus.OK);
        } catch (Exception e) {
           
            log.error("An error occurred while fetching products", e);

           
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(null);
        }
    }

    @GetMapping("/{id}")
    public Product getProductById(@PathVariable(value = "id") Long id) {

        return ps.getProductById(id);
    }

    @PutMapping("/{id}")
    public Product updateProduct(@PathVariable(value = "id") Long id, @RequestBody Product productDetails) {
        return ps.updateProduct(id, productDetails);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteProduct(@PathVariable(value = "id") Long id) {
        ps.deleteProduct(id);
        return ResponseEntity.ok().build();
    }

    @GetMapping("/products")
    public Page<Product> getProductsByCategory(
            @RequestParam Long categoryId,
            @RequestParam(defaultValue = "0") int page,
            @RequestParam(defaultValue = "10") int size) {
        PageRequest pageable = PageRequest.of(page, size);
        Category category = ( cs.findById(categoryId));
        return ps.findByCategory(category, pageable);
    }

}
