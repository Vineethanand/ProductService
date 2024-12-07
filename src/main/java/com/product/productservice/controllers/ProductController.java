package com.product.productservice.controllers;

import com.product.productservice.exceptions.ProductNotFoundException;
import com.product.productservice.models.FakeStoreProduct;
import com.product.productservice.models.Product;
import com.product.productservice.projections.ProductTitleAndDescription;
import com.product.productservice.services.ProductService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/products")
public class ProductController {

    ProductService productService;

    public ProductController(ProductService productService) {
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
    public ResponseEntity<ProductTitleAndDescription> getProduct(@PathVariable Long id) throws ProductNotFoundException {
        ProductTitleAndDescription product = productService.getProductById(id);
        return new ResponseEntity<>(product, HttpStatus.OK);
    }

    @PostMapping
    public Product createProduct(@RequestBody Product product){
        return productService.createProduct(product);
    }
}
