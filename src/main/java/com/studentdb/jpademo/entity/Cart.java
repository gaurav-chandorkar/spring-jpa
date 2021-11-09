package com.studentdb.jpademo.entity;

import lombok.*;

import javax.annotation.Generated;
import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
@Entity
@Table(name = "Cart")
public class Cart {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
    private String name;

    @OneToMany(mappedBy = "cart",
    cascade = CascadeType.ALL,
    orphanRemoval = true)
    List<Item> items=new ArrayList<>();
}
