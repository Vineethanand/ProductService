package com.product.productservice.dtos;


import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class ProductNotFoundExceptionDto {
    Long error;
    String errormessage;

}
