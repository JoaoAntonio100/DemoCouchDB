package com.couchdb.demo.controller;

import com.couchdb.demo.model.Product;
import com.couchdb.demo.service.ProductService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/products")
public class ProductController {
    private final ProductService service;

    public ProductController(ProductService service) {
        this.service = service;
    }

    @PostMapping
    public Product create(@RequestBody Product p) {
        return service.save(p);
    }

    @GetMapping
    public List<Product> all() {
        return service.findAll();
    }

    @GetMapping("/{id}")
    public Product one(@PathVariable String id) {
        return service.findById(id);
    }

    @PutMapping("/{id}")
    public Product update(@PathVariable String id, @RequestBody Product p) {
        return service.update(id, p);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable String id) {
        service.delete(id);
    }
}
