package com.studentdb.jpademo.entity;

import lombok.*;

import javax.persistence.*;

@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter
@Entity
@Table(name = "Item")
@Builder
public class Item {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    Long id;
    @ManyToOne()
    @JoinColumn(name = "cart_id")
    Cart cart;
    private String serialNumber;
}
