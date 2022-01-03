package ru.gb.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import ru.gb.entity.User;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {


    Optional<User> findByEmail(String email);

//    @Modifying
//    @Query("UPDATE User as u SET u.roles ='$authority'  where u.id = :id")
//    @Transactional
//    void update(User id);
//
//    @Query("FROM User WHERE email=:username")
//    User findByUsername(@Param("email") String username);
//
//    @Query("FROM User")
//    List<User> userList();
}