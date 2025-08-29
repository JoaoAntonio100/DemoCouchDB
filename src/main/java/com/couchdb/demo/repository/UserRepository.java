package com.couchdb.demo.repository;

import org.ektorp.CouchDbConnector;
import org.ektorp.support.CouchDbRepositorySupport;
import org.springframework.stereotype.Repository;

import com.couchdb.demo.model.User;

@Repository
public class UserRepository extends CouchDbRepositorySupport<User> {

    public UserRepository(CouchDbConnector db) {
        super(User.class, db);
        initStandardDesignDocument();
    }
}
