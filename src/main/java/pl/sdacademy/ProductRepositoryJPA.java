package pl.sdacademy;

import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepositoryJPA extends JpaRepository<Product, Integer> {
}