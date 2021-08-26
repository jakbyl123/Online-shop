package pl.sdacademy.product;


import pl.sdacademy.category.Category;

import javax.persistence.*;

@Entity
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String name;
    private String description;
    private String url;
    @ManyToOne
    private Category category;
    private double price;

    public Product() {
    }

    public Product(String title, String description, String url, Category category, double price) {
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

    public Category getCategory() {
        return category;
    }

    public double getPrice() {
        return price;
    }

    @Override
    public String toString() {
        return "Product{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", description='" + description + '\'' +
                ", url='" + url + '\'' +
                ", category='" + category + '\'' +
                ", price=" + price +
                '}';
    }
}