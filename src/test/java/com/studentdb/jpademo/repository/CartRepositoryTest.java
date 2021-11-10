package com.studentdb.jpademo.repository;

import com.studentdb.jpademo.entity.Cart;
import com.studentdb.jpademo.entity.Item;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class CartRepositoryTest {

    @Autowired
    CartRepository cartRepository;

    @Test
    public void insertData(){

        Cart cart= Cart.builder().name("008").build();
        Item chocolate=Item.builder().serialNumber("s123").cart(cart).build();
        Item mobile=Item.builder().serialNumber("sm321").cart(cart).build();
        List<Item> items = Arrays.asList(chocolate,mobile);
        cart.setItems(items);

        cartRepository.save(cart);
    }

    @Test
    public void deleteCart(){
        Cart cart=cartRepository.findByName("c888");

        cartRepository.delete(cart);
    }
}