package com.couchdb.demo.config;

import org.ektorp.CouchDbConnector;
import org.ektorp.CouchDbInstance;
import org.ektorp.http.StdHttpClient;
import org.ektorp.impl.StdCouchDbConnector;
import org.ektorp.impl.StdCouchDbInstance;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.net.MalformedURLException;

@Configuration
public class CouchDbConfig {

    @Bean
    public CouchDbConnector couchDbConnector() throws MalformedURLException {
        StdHttpClient.Builder builder = new StdHttpClient.Builder()
                .url("http://127.0.0.1:5984") // endereço do CouchDB
                .username("Joao")            // usuário (se tiver)
                .password("xkp93cf5");           // senha (se tiver)

        CouchDbInstance dbInstance = new StdCouchDbInstance(builder.build());
        CouchDbConnector db = new StdCouchDbConnector("users", dbInstance); // nome do banco
        db.createDatabaseIfNotExists();
        return db;
    }
}
