package com.product.productservice.inheritance.mappedsuperlcass;

import jakarta.persistence.Entity;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity(name="ms_students")
public class Student extends User{
    String batch;
    Double psp;
}
