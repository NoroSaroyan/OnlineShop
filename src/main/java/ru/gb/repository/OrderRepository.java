package ru.gb.repository;

import org.springframework.data.repository.CrudRepository;
import ru.gb.entity.Order;

import java.util.List;
import java.util.Optional;

public interface OrderRepository extends CrudRepository<Order, Long> {
    Optional<Order> findById(Long id);

    Optional<List<Order>> findAllByUserName(String username);
}
