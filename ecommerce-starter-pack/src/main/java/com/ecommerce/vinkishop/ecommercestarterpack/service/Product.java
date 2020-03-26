package com.ecommerce.vinkishop.ecommercestarterpack.service;

import com.sun.istack.NotNull;

import javax.persistence.Basic;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull(message="Product name is required.")
    @Basic(optionl=false)
    private String name;

    private Double price;

    private String pictureUrl;


}
