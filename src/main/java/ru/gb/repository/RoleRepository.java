package ru.gb.repository;

import org.springframework.data.repository.CrudRepository;
import ru.gb.entity.Role;

import java.util.Optional;

public interface RoleRepository extends CrudRepository<Role, Long> {
    @Override
    Optional<Role> findById(Long aLong);

    @Override
    Iterable<Role> findAll();
}
