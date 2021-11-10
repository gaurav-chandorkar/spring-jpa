package com.studentdb.jpademo;

import com.studentdb.jpademo.entity.Cart;
import com.studentdb.jpademo.entity.Item;
import com.studentdb.jpademo.repository.CartRepository;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

import java.util.Arrays;
import java.util.List;

@SpringBootApplication
public class JpaDemoApplication {

    public static void main(String[] args) {
        ConfigurableApplicationContext applicationContext = SpringApplication.run(JpaDemoApplication.class, args);
        CartRepository cartRepository = applicationContext.getBean(CartRepository.class);

        Cart cart = Cart.builder().name("www88").build();
        Item chocolate = Item.builder().serialNumber("wp123").cart(cart).build();
        Item mobile = Item.builder().serialNumber("pw321").cart(cart).build();
        List<Item> items = Arrays.asList(chocolate, mobile);
        cart.setItems(items);

        cartRepository.save(cart);

    }


}
