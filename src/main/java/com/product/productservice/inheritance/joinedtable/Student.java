package com.product.productservice.inheritance.joinedtable;

import jakarta.persistence.Entity;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity(name="jt_students")
public class Student extends User {
    String batch;
    Double psp;
}
