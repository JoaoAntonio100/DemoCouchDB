package com.couchdb.demo.model;

import org.ektorp.support.CouchDbDocument;

public class Consumer extends CouchDbDocument {

    private String type = "consumer";
    private String name;
    private String email;

    // getters/setters de campos
    public String getType() { return type; }
    public void setType(String type) { this.type = type; }

    public String getName() { return name; }
    public void setName(String name) { this.name = name; }

    public String getEmail() { return email; }
    public void setEmail(String email) { this.email = email; }

    // expor _id e _rev
    @Override public String getId() { return super.getId(); }
    @Override public void setId(String id) { super.setId(id); }

    @Override public String getRevision() { return super.getRevision(); }
    @Override public void setRevision(String rev) { super.setRevision(rev); }
}
