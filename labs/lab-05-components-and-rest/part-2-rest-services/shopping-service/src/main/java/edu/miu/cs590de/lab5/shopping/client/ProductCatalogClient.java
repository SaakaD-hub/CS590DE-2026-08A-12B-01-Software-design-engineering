package edu.miu.cs590de.lab5.shopping.client;

import edu.miu.cs590de.lab5.shopping.domain.Money;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestClient;

/**
 * The Shopping component's required interface IProductCatalog.
 *
 * Part 1 shows ShoppingComponent depending on IProductCatalog. Because the two
 * components are deployed separately, that dependency is satisfied over HTTP
 * instead of by a direct method call. Nothing else in this component knows the
 * Product component is remote.
 */
@Component
public class ProductCatalogClient {

    private final RestClient restClient;

    public ProductCatalogClient(@Value("${productcatalog.base-url}") String baseUrl) {
        this.restClient = RestClient.create(baseUrl);
    }

    public ProductView getProduct(String productNumber) {
        return restClient.get()
                .uri("/api/products/{productNumber}", productNumber)
                .retrieve()
                .body(ProductView.class);
    }

    /** What the Shopping component needs to know about a product - nothing more. */
    public record ProductView(String productNumber, String name, String description, Money price) {
    }
}
