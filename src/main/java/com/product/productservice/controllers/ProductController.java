package com.product.productservice.controllers;

import com.product.productservice.exceptions.ProductNotFoundException;
import com.product.productservice.models.FakeStoreProduct;
import com.product.productservice.models.Product;
import com.product.productservice.projections.ProductTitleAndDescription;
import com.product.productservice.services.ProductService;
import com.product.productservice.services.TokenService;
import org.hibernate.cache.spi.access.UnknownAccessTypeException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/products")
public class ProductController {

    ProductService productService;
    TokenService tokenService;

    public ProductController(ProductService productService,
                             TokenService tokenService) {
        this.tokenService = tokenService;
        this.productService = productService;
    }

//    @GetMapping("/{id}")
//    public ResponseEntity<FakeStoreProduct> getFakeStoreProductById(@PathVariable Long id) throws ProductNotFoundException {
//        FakeStoreProduct product = productService.getFakeStoreProductById(id);
//        return new ResponseEntity<>(product, HttpStatus.OK);
//    }
//
//    @GetMapping("/")
//    public List<FakeStoreProduct> getFakeStoreProducts() {
//        return productService.getFakeStoreProducts();
//    }
//
//    @PutMapping("/{id}")
//    public FakeStoreProduct replaceFakeStoreProduct(@PathVariable Long id, @RequestBody FakeStoreProduct product) {
//        return productService.replaceFakeStoreProduct(id, product);
//    }
//
//    @PostMapping("/")
//    public ResponseEntity<FakeStoreProduct> createFakeStoreProduct(@RequestBody FakeStoreProduct product) {
//        FakeStoreProduct fakeStoreProduct = productService.createFakeStoreProduct(product);
//        return new ResponseEntity<>(fakeStoreProduct, HttpStatus.CREATED);
//    }
//
//    @PatchMapping("/{id}")
//    public ResponseEntity<FakeStoreProduct> updateFakeStoreProduct(@PathVariable Long id, @RequestBody FakeStoreProduct product) {
//        FakeStoreProduct fakeStoreProduct = productService.updateFakeStoreProduct(id, product);
//        return new ResponseEntity<>(fakeStoreProduct, HttpStatus.OK);
//    }

    @GetMapping("{id}")
    public ResponseEntity<Product> getProduct(
            @RequestHeader("Token") String token,
            @PathVariable Long id) throws ProductNotFoundException {

        if(tokenService.validateToken(token)) {
            Product product = productService.getProductById(id);
            return new ResponseEntity<>(product, HttpStatus.OK);
        }
        else {
            throw new UnknownAccessTypeException("User is not authorized");
        }
    }

    @PostMapping
    public Product createProduct(@RequestBody Product product){
        return productService.createProduct(product);
    }
}
