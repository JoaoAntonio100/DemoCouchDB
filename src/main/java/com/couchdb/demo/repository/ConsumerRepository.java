package com.couchdb.demo.repository;

import com.couchdb.demo.model.Consumer;
import org.ektorp.CouchDbConnector;
import org.ektorp.support.CouchDbRepositorySupport;
import org.springframework.stereotype.Repository;

@Repository
public class ConsumerRepository extends CouchDbRepositorySupport<Consumer> {
    public ConsumerRepository(CouchDbConnector db) {
        super(Consumer.class, db);
        initStandardDesignDocument();
    }
}
