package pl.sdacademy.category;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Category {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String name;


    public Category(String name) {
        this.name = name;
    }

    public Category() {
    }

    public Integer getId() {
        return id;
    }

    public String getName() {
        return name;
    }
}
