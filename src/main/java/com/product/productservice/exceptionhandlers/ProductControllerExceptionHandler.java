package com.product.productservice.exceptionhandlers;

import com.product.productservice.dtos.ProductNotFoundExceptionDto;
import com.product.productservice.exceptions.ProductNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class ProductControllerExceptionHandler {

    @ExceptionHandler(ProductNotFoundException.class)
    public ResponseEntity<ProductNotFoundExceptionDto> handleProductNotFoundException(ProductNotFoundException exception){
        ProductNotFoundExceptionDto dto = new ProductNotFoundExceptionDto();
//        dto.setErrormessage(exception.getMessage());
//        dto.setError(exception.getError());
        return new ResponseEntity<>(dto, HttpStatus.NOT_FOUND);
    }
}
