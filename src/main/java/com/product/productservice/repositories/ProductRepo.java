package com.product.productservice.repositories;

import com.product.productservice.models.Product;
import com.product.productservice.projections.ProductTitleAndDescription;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface ProductRepo extends JpaRepository<Product, Long>
{
    @Override
    Optional<Product> findById(Long id);

    //@Query("select p.title as title, p.description as description from Product p where p.id = :id")
    //Optional<ProductTitleAndDescription> getProductTitleandDesc(@Param("id") Long id);

    //HQL
    @Query("SELECT p.title as title, p.description as description FROM products p WHERE p.id = :id")
    Optional<ProductTitleAndDescription> getProductTitleAndDescriptionById(@Param("id") Long id);
}
