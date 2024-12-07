package com.product.productservice.services;

import com.product.productservice.exceptions.ProductNotFoundException;
import com.product.productservice.models.FakeStoreProduct;
import com.product.productservice.models.Product;
import com.product.productservice.projections.ProductTitleAndDescription;
import org.springframework.stereotype.Service;

import java.util.List;

public interface ProductService {
//    public FakeStoreProduct getFakeStoreProductById(Long id) throws ProductNotFoundException;
//
//    List<FakeStoreProduct> getFakeStoreProducts();
//
//    FakeStoreProduct replaceFakeStoreProduct(Long id, FakeStoreProduct product);
//
//    FakeStoreProduct createFakeStoreProduct(FakeStoreProduct product);
//
//    FakeStoreProduct updateFakeStoreProduct(Long id, FakeStoreProduct product);
    ProductTitleAndDescription getProductById(Long id) throws ProductNotFoundException;

    Product createProduct(Product product);
}
