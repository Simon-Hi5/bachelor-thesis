package edu.hm.opportunity;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "opportunityModels")
public class OpportunityModel {

    @Id
    private String id;

    private String name;

    private int quantity;

    public OpportunityModel(String name, int quantity) {
        super();
        this.name = name;
        this.quantity = quantity;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    @Override
    public String toString() {
        return "OpportunityModel{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", quantity=" + quantity +
                '}';
    }

}
