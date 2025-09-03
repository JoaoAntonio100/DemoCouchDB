package com.couchdb.demo.model;

import org.ektorp.support.CouchDbDocument;

public class Product extends CouchDbDocument {

    private String type = "product";
    private String name;
    private Double price;
    private String consumerId; // "relacionamento" manual

    public String getType() { return type; }
    public void setType(String type) { this.type = type; }

    public String getName() { return name; }
    public void setName(String name) { this.name = name; }

    public Double getPrice() { return price; }
    public void setPrice(Double price) { this.price = price; }

    public String getConsumerId() { return consumerId; }
    public void setConsumerId(String consumerId) { this.consumerId = consumerId; }

    @Override public String getId() { return super.getId(); }
    @Override public void setId(String id) { super.setId(id); }

    @Override public String getRevision() { return super.getRevision(); }
    @Override public void setRevision(String rev) { super.setRevision(rev); }
}
