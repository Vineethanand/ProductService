package com.product.productservice.inheritance.tableperclass;

import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity(name="tpc_intructors")
public class Instructor extends User {
    Double rating;
}
