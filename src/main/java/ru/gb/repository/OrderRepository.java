package ru.gb.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.Repository;
import ru.gb.entity.Order;

import java.util.Optional;

public interface OrderRepository extends CrudRepository<Order, Long> {
    Optional<Order> findById(Long id);
}
