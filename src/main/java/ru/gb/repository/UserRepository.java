package ru.gb.repository;

import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import ru.gb.entity.User;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

public interface UserRepository extends CrudRepository<User, Long> {
    Optional<User> findByEmail(String email);

    List<User> findAll();

    User getById(long id);

    void deleteById(long id);

    @Modifying
    @Query("UPDATE User as u SET u.roles ='$authority'  where u.id = :id")
    @Transactional
    void update(long id);
}