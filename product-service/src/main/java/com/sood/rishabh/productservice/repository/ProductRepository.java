package com.sood.rishabh.productservice.repository;

import com.sood.rishabh.productservice.models.Product;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface ProductRepository extends MongoRepository<Product, String> {
}
