package pl.sdacademy.user;

import javax.persistence.*;

@Embeddable
public class UserAddress {
    private String country;
    private String city;
    private String street;
    private Integer postalCode;

    public UserAddress(String country, String city, String street, Integer postalCode) {
        this.country = country;
        this.city = city;
        this.street = street;
        this.postalCode = postalCode;
    }

    public UserAddress() {
    }


    public String getCountry() {
        return country;
    }

    public String getCity() {
        return city;
    }

    public String getStreet() {
        return street;
    }

    public Integer getPostalCode() {
        return postalCode;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public void setPostalCode(Integer postalCode) {
        this.postalCode = postalCode;
    }
}
