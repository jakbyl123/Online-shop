package pl.sdacademy;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String title;
    private String description;
    private String url;
    private String category;
    private double price;
    private String ProductType;

    public Product() {
    }

    public Product(String title, String description, String url, String category, double price, String productType) {
        this.title = title;
        this.description = description;
        this.url = url;
        this.category = category;
        this.price = price;
        ProductType = productType;
    }
}