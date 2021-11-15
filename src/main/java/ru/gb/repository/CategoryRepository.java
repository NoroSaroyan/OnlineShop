package ru.gb.repository;

import org.springframework.data.repository.CrudRepository;
import ru.gb.entity.Category;

import java.util.Optional;

public interface CategoryRepository extends CrudRepository<Category, Long> {
    Optional<Category> findById(Long id);
}
