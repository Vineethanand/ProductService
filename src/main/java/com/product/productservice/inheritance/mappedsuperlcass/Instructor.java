package com.product.productservice.inheritance.mappedsuperlcass;

import jakarta.persistence.Entity;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity(name="ms_intructors")
public class Instructor extends User{
    Double rating;
}
