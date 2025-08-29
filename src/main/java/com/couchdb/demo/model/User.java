package com.couchdb.demo.model;

import org.ektorp.support.CouchDbDocument;

public class User extends CouchDbDocument {

    private String name;
    private String email;

    // Getters e Setters próprios
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }
    public void setEmail(String email) {
        this.email = email;
    }

    // 🔑 Sobrescrevendo para expor publicamente
    @Override
    public void setId(String id) {
        super.setId(id);
    }

    @Override
    public String getId() {
        return super.getId();
    }
}
