package edu.miu.cs590de.lab5.shopping.repository;

import edu.miu.cs590de.lab5.shopping.domain.ShoppingCart;
import org.springframework.data.mongodb.repository.MongoRepository;

/**
 * The data access part of the Shopping component.
 */
public interface ShoppingCartRepository extends MongoRepository<ShoppingCart, String> {
}
