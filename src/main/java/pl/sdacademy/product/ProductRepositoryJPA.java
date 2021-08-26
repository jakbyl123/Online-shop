package pl.sdacademy.product;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

public interface ProductRepositoryJPA extends JpaRepository<Product, Integer> {
    @Query("SELECT p FROM Product p WHERE CONCAT(COALESCE(p.name, ''), COALESCE(p.category.name, ''), COALESCE(p.description, ''), COALESCE(p.price, 0)) LIKE %:param%")
    List<Product> search(@Param("param") String keyword);
}