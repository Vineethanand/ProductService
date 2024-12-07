package com.product.productservice.exceptions;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ProductNotFoundException extends Exception{

    Long error;

    public ProductNotFoundException(Long err_code, String message){
        super(message);
        this.error = err_code;
    }
}
