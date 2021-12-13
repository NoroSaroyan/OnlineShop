package ru.gb.repository;

import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;
import ru.gb.entity.Cart;

import javax.transaction.Transactional;

public interface CartRepository extends PagingAndSortingRepository<Cart, Long> {

    @Query("select c from Cart as c ")
    Iterable<Cart> findAll();

    @Query("SELECT c FROM Cart  as c WHERE c.id = :id")
    Cart getById(@Param("id") long id);

    @Modifying
    @Transactional
    @Query(value = "insert into carts(productCount, product_id) values (:productCount, :product_id)", nativeQuery = true)
    Cart saveProductToCart(@Param("product_id") long product_id, @Param("productCount") long productCount);

}