package com.couchdb.demo.config;

import org.ektorp.CouchDbConnector;
import org.ektorp.CouchDbInstance;
import org.ektorp.http.StdHttpClient;
import org.ektorp.impl.StdCouchDbConnector;
import org.ektorp.impl.StdCouchDbInstance;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.net.MalformedURLException;

@Configuration
public class CouchDbConfig {

    @Value("${couchdb.url}")
    private String url;

    @Value("${couchdb.username:}")
    private String username;

    @Value("${couchdb.password:}")
    private String password;

    @Value("${couchdb.dbname}")
    private String dbName;

    @Bean
    public CouchDbConnector couchDbConnector() throws MalformedURLException {
        StdHttpClient.Builder builder = new StdHttpClient.Builder().url(url);
        if (!username.isEmpty()) {
            builder.username(username).password(password);
        }
        CouchDbInstance dbInstance = new StdCouchDbInstance(builder.build());
        CouchDbConnector db = new StdCouchDbConnector(dbName, dbInstance);
        db.createDatabaseIfNotExists();
        return db;
    }
}
