package com.product.productservice.inheritance.joinedtable;

import jakarta.persistence.Entity;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity(name="jt_intructors")
public class Instructor extends User {
    Double rating;
}
