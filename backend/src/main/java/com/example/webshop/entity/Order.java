package com.example.webshop.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.Collection;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Order {

    @Id
    @GeneratedValue
    private Long id;

    @ManyToOne
    @NotNull
    private User user;

    @NotNull
    private String billingAddress;

    @NotNull
    private String shippingAddress;

    @OneToMany
    private Collection<Product> products;

}
