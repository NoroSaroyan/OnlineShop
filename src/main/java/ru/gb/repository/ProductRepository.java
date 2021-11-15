package ru.gb.repository;

import org.springframework.data.repository.CrudRepository;
import ru.gb.entity.Product;

import java.util.Optional;

public interface ProductRepository extends CrudRepository<Product, Long> {

    Optional<Product> findById(Long id);
}
