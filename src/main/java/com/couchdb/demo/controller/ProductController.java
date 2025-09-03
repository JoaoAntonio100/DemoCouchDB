package com.couchdb.demo.controller;

import com.couchdb.demo.model.Product;
import com.couchdb.demo.service.ProductService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/products")
public class ProductController {

    private final ProductService productService;
    public ProductController(ProductService productService) { this.productService = productService; }

    @PostMapping
    public Product create(@RequestBody Product p) {
        return productService.save(p);
    }

    @GetMapping
    public List<Product> all() { return productService.findAll(); }

    @GetMapping("/{id}")
    public Product one(@PathVariable String id) { return productService.findById(id); }

    @GetMapping("/by-consumer/{consumerId}")
    public List<Product> byConsumer(@PathVariable String consumerId) {
        return productService.findByConsumerId(consumerId);
    }

    @PutMapping("/{id}")
    public Product update(@PathVariable String id, @RequestBody Product p) {
        return productService.update(id, p);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable String id) { productService.delete(id); }
}