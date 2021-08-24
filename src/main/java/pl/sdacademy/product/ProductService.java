package pl.sdacademy.product;

import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductService {
    private ProductRepositoryJPA productRepositoryJPA;

    public ProductService(ProductRepositoryJPA productRepositoryJPA) {
        this.productRepositoryJPA = productRepositoryJPA;
    }

    public List<Product> getAll(String keyword) {
        if (keyword != null) {
            return productRepositoryJPA.search(keyword);
        }
        return productRepositoryJPA.findAll();
    }


}
