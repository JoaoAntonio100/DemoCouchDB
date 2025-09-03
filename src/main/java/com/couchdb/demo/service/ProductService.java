package com.couchdb.demo.service;

import com.couchdb.demo.model.Product;
import com.couchdb.demo.repository.ProductRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductService {
    private final ProductRepository productRepo;

    public ProductService(ProductRepository productRepo) {
        this.productRepo = productRepo;
    }

    public Product save(Product p) {
        productRepo.add(p);
        return p;
    }

    public List<Product> findAll() { return productRepo.getAll(); }
    public Product findById(String id) { return productRepo.get(id); }
    public List<Product> findByConsumerId(String consumerId) { return productRepo.findByConsumerId(consumerId); }

    public Product update(String id, Product incoming) {
        Product current = productRepo.get(id);
        current.setName(incoming.getName());
        current.setPrice(incoming.getPrice());
        // se quiser permitir troca de dono:
        current.setConsumerId(incoming.getConsumerId());
        productRepo.update(current);
        return current;
    }

    public void delete(String id) {
        Product p = productRepo.get(id);
        if (p != null) productRepo.remove(p);
    }
}
