package com.product.productservice.inheritance.singletable;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity(name="st_users")
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
public class User {
    @Id
    Long id;
    String name;
    String email;
    Long phone;
}
