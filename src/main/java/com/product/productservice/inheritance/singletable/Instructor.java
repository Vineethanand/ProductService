package com.product.productservice.inheritance.singletable;

import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity(name="st_intructors")
@DiscriminatorValue(value="3")
public class Instructor extends User {
    Double rating;
}
