package com.product.productservice.inheritance.joinedtable;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity(name="jt_users")
@Inheritance(strategy = InheritanceType.JOINED)
public class User {
    @Id
    Long id;
    String name;
    String email;
    Long phone;
}
