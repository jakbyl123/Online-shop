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
    private String name;
    private String description;
    private String url;
    private String category;
    private double price;

    public Product() {
    }

    public Product(String title, String description, String url, String category, double price) {
        this.name = title;
        this.description = description;
        this.url = url;
        this.category = category;
        this.price = price;
    }

    public Integer getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }

    public String getUrl() {
        return url;
    }

    public String getCategory() {
        return category;
    }

    public double getPrice() {
        return price;
    }
}