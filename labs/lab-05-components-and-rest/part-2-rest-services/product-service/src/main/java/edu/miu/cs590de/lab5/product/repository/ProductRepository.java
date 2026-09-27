package edu.miu.cs590de.lab5.product.repository;

import edu.miu.cs590de.lab5.product.domain.Product;
import org.springframework.data.mongodb.repository.MongoRepository;

/**
 * The data access part of the Product component. Nothing outside this
 * component is allowed to use it.
 */
public interface ProductRepository extends MongoRepository<Product, String> {
}
