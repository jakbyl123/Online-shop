package pl.sdacademy;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductRepositoryJPA extends JpaRepository<Product, Integer> {

}