package com.wiredbraincoffe.productapifunctional.repository;

import com.wiredbraincoffe.productapifunctional.model.Product;
import org.springframework.data.mongodb.repository.ReactiveMongoRepository;

public interface ProductRepository
        extends ReactiveMongoRepository<Product, String> {
}