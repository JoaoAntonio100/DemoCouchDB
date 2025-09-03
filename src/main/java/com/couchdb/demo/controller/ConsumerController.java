package com.couchdb.demo.controller;

import com.couchdb.demo.model.Consumer;
import com.couchdb.demo.model.Product;
import com.couchdb.demo.service.ConsumerService;
import com.couchdb.demo.service.ProductService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/consumers")
public class ConsumerController {

    private final ConsumerService consumerService;
    private final ProductService productService;

    public ConsumerController(ConsumerService consumerService, ProductService productService) {
        this.consumerService = consumerService;
        this.productService = productService;
    }

    @PostMapping
    public Consumer create(@RequestBody Consumer c) {
        return consumerService.save(c);
    }

    @GetMapping
    public List<Consumer> all() {
        return consumerService.findAll();
    }

    @GetMapping("/{id}")
    public Consumer one(@PathVariable String id) {
        return consumerService.findById(id);
    }

    @PutMapping("/{id}")
    public Consumer update(@PathVariable String id, @RequestBody Consumer c) {
        return consumerService.update(id, c);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable String id) {
        consumerService.delete(id); // deleta também os produtos do consumidor
    }

    // ---- Endpoints do relacionamento ----

    // Lista produtos de um consumidor
    @GetMapping("/{id}/products")
    public List<Product> productsOf(@PathVariable String id) {
        return productService.findByConsumerId(id);
    }

    // Cria produto já vinculado ao consumidor
    @PostMapping("/{id}/products")
    public Product addProductTo(@PathVariable String id, @RequestBody Product p) {
        p.setConsumerId(id);
        p.setType("product");
        return productService.save(p);
    }
}
