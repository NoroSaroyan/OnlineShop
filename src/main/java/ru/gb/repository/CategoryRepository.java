package ru.gb.repository;

import org.springframework.data.repository.CrudRepository;
import ru.gb.entity.Category;

import java.util.List;
import java.util.Optional;

public interface CategoryRepository extends CrudRepository<Category, Long> {
    Optional<Category> findById(Long id);

    List<Category> findAll();

}
