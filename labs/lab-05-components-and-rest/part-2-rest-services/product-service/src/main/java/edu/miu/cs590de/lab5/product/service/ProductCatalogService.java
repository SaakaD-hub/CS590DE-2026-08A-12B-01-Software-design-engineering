package edu.miu.cs590de.lab5.product.service;

import edu.miu.cs590de.lab5.product.domain.Product;
import edu.miu.cs590de.lab5.product.repository.ProductRepository;
import org.springframework.stereotype.Service;

import java.util.Optional;

/**
 * Implements IProductCatalog from the Part 1 component design.
 * Holds no business logic itself - it loads, delegates and saves.
 */
@Service
public class ProductCatalogService {

    private final ProductRepository productRepository;

    public ProductCatalogService(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    public Product addProduct(Product product) {
        return productRepository.save(product);
    }

    public Optional<Product> getProduct(String productNumber) {
        return productRepository.findById(productNumber);
    }
}
