package com.product.productservice.services;

import com.product.productservice.exceptions.ProductNotFoundException;
import com.product.productservice.models.Category;
import com.product.productservice.models.FakeStoreProduct;
import com.product.productservice.models.Product;
import com.product.productservice.projections.ProductTitleAndDescription;
import com.product.productservice.repositories.CategoryRepo;
import com.product.productservice.repositories.ProductRepo;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class SelfProductService implements ProductService {

    ProductRepo productRepo;
    CategoryRepo categoryRepo;

    public SelfProductService(ProductRepo productRepo, CategoryRepo categoryRepo) {
        this.productRepo = productRepo;
        this.categoryRepo = categoryRepo;
    }

    @Override
    public ProductTitleAndDescription getProductById(Long id) throws ProductNotFoundException {
//        Optional<Product> product =  productRepo.findById(id);
//        if(product.isEmpty())
//            throw new ProductNotFoundException(101L, "Product with " + id + " not found");
//        else
//            return product.get();
        Optional<ProductTitleAndDescription> productTitleAndDescription = productRepo.getProductTitleAndDescriptionById(id);
        if (productTitleAndDescription.isPresent()) {
            System.out.println(productTitleAndDescription.get());
            return productTitleAndDescription.get();
            //ProductTitleAndDescription productTitleAndDescription1 =  productTitleAndDescription.get();

            //Product p = new Product();
            //p.setTitle(productTitleAndDescription1.getTitle());
            //p.setDescription(productTitleAndDescription1.getDescription());
            //return null;
        }
        else
        {
            throw new ProductNotFoundException(101L, "Product with " + id + " not found");
        }
    }

    @Override
    public Product createProduct(Product product) {
//        Category category = product.getCategory();
//        if (category.getId() == null) {
//
//            Category savedCategory = categoryRepo.save(category);
//            product.setCategory(savedCategory);
//        }
//        else
//        {
//            //Validation of categories
//        }
        return productRepo.save(product);
    }
}
