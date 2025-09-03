package com.couchdb.demo.repository;

import com.couchdb.demo.model.Product;
import org.ektorp.CouchDbConnector;
import org.ektorp.support.CouchDbRepositorySupport;
import org.ektorp.support.View;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class ProductRepository extends CouchDbRepositorySupport<Product> {
    public ProductRepository(CouchDbConnector db) {
        super(Product.class, db);
        initStandardDesignDocument();
    }

    // View para indexar produtos por consumerId
    @View(name = "by_consumerId",
          map  = "function(doc) { if(doc.type === 'product' && doc.consumerId) emit(doc.consumerId, null); }")
    public List<Product> findByConsumerId(String consumerId) {
        return queryView("by_consumerId", consumerId);
    }
}
