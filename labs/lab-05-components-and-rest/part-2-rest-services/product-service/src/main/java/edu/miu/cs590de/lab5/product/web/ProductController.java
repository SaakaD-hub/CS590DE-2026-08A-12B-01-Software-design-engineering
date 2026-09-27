package edu.miu.cs590de.lab5.product.web;

import edu.miu.cs590de.lab5.product.domain.Product;
import edu.miu.cs590de.lab5.product.service.ProductCatalogService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

/**
 * The REST interface of the Product component - the network form of
 * IProductCatalog.
 *
 *   POST /api/products                   addProduct
 *   GET  /api/products/{productNumber}   getProduct
 */
@RestController
@RequestMapping("/api/products")
public class ProductController {

    private final ProductCatalogService productCatalogService;

    public ProductController(ProductCatalogService productCatalogService) {
        this.productCatalogService = productCatalogService;
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Product addProduct(@RequestBody Product product) {
        return productCatalogService.addProduct(product);
    }

    @GetMapping("/{productNumber}")
    public ResponseEntity<Product> getProduct(@PathVariable String productNumber) {
        return productCatalogService.getProduct(productNumber)
                .map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.notFound().build());
    }
}
