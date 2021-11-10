package com.studentdb.jpademo.repository;

import com.studentdb.jpademo.entity.Cart;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CartRepository extends CrudRepository<Cart,Long> {

     Cart findByName(String name);
}
