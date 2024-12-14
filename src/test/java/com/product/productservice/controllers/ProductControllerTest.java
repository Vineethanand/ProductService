package com.product.productservice.controllers;

import ch.qos.logback.core.testUtil.RandomUtil;
import com.product.productservice.exceptions.ProductNotFoundException;
import com.product.productservice.models.Product;
import com.product.productservice.services.ProductService;
import net.bytebuddy.utility.RandomString;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.bean.override.mockito.MockitoBean;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

@SpringBootTest
class ProductControllerTest {
    @MockitoBean
    private ProductService service;
    @Autowired
    private ProductController productController;

    @Test
    void getProduct() throws ProductNotFoundException {
        Product product = new Product();
        Long productId = 1L;
        product.setId(productId);
        product.setTitle("Test_Title");
        product.setDescription("Test_Desc");
        product.setPrice(20.0);

        String token = RandomString.make(10);
        when(service.getProductById(productId)).thenReturn(product);

        Product p = productController.getProduct(token, productId).getBody();

        assertEquals("Test_Title", p.getTitle());
    }

    @Test
    void createProduct() {
        Product product = new Product();
        Long productId = 1L;
        product.setId(productId);
        product.setTitle("Test_Title");
        product.setDescription("Test_Desc");
        product.setPrice(20.0);

        when(service.createProduct(product)).thenReturn(product);

        //verify(productController.createProduct(product));
    }
}