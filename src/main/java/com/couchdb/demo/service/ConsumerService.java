package com.couchdb.demo.service;

import com.couchdb.demo.model.Consumer;
import com.couchdb.demo.model.Product;
import com.couchdb.demo.repository.ConsumerRepository;
import com.couchdb.demo.repository.ProductRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ConsumerService {
    private final ConsumerRepository consumerRepo;
    private final ProductRepository productRepo;

    public ConsumerService(ConsumerRepository consumerRepo, ProductRepository productRepo) {
        this.consumerRepo = consumerRepo;
        this.productRepo = productRepo;
    }

    // CREATE
    public Consumer save(Consumer c) {
        consumerRepo.add(c);
        return c;
    }

    // READ
    public List<Consumer> findAll() { return consumerRepo.getAll(); }
    public Consumer findById(String id) { return consumerRepo.get(id); }

    // UPDATE (precisa do _rev mais recente)
    public Consumer update(String id, Consumer incoming) {
        Consumer current = consumerRepo.get(id);
        current.setName(incoming.getName());
        current.setEmail(incoming.getEmail());
        consumerRepo.update(current);
        return current;
    }

    // DELETE (com cascata nos produtos)
    public void delete(String id) {
        Consumer c = consumerRepo.get(id);
        if (c != null) {
            // apaga produtos do consumidor
            List<Product> products = productRepo.findByConsumerId(id);
            for (Product p : products) {
                productRepo.remove(p);
            }
            // apaga o consumidor
            consumerRepo.remove(c);
        }
    }
}
