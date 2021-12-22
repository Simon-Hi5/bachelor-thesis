package edu.hm.contact;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import javax.validation.constraints.Pattern;

enum Country {
    GERMANY, AUSTRIA, SWITZERLAND
}

@Document(collection = "addresses")
public class Address {

    @Id
    private String id;

    private String address;

    private String additionalAddress;

    @Pattern(regexp = "^\\d{4,5}$", message = "Postcode should be valid")
    private String postcode;

    private String town;

    private Country country;

    public Address(String address, String additionalAddress, String postcode, String town, Country country) {
        this.address = address;
        this.additionalAddress = additionalAddress;
        this.postcode = postcode;
        this.town = town;
        this.country = country;
    }

    public String getId() {
        return id;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getAdditionalAddress() {
        return additionalAddress;
    }

    public void setAdditionalAddress(String additionalAddress) {
        this.additionalAddress = additionalAddress;
    }

    public String getPostcode() {
        return postcode;
    }

    public void setPostcode(String postcode) {
        this.postcode = postcode;
    }

    public String getTown() {
        return town;
    }

    public void setTown(String town) {
        this.town = town;
    }

    public Country getCountry() {
        return country;
    }

    public void setCountry(Country country) {
        this.country = country;
    }

    @Override
    public String toString() {
        return "Address{" +
                "address='" + address + '\'' +
                ", additionalAddress='" + additionalAddress + '\'' +
                ", postcode='" + postcode + '\'' +
                ", town='" + town + '\'' +
                ", country=" + country +
                '}';
    }

}
