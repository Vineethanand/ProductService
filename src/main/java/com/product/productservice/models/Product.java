package com.product.productservice.models;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.ManyToOne;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity(name="products")
public class Product extends BaseModel{
    String name;
    Double price;
    String description;
    @ManyToOne(cascade=CascadeType.DETACH)
    Category category;
}
