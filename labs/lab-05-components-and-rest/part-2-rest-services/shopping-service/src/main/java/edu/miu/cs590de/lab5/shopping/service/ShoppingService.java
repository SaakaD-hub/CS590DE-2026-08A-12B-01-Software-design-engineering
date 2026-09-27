package edu.miu.cs590de.lab5.shopping.service;

import edu.miu.cs590de.lab5.shopping.client.ProductCatalogClient;
import edu.miu.cs590de.lab5.shopping.domain.ShoppingCart;
import edu.miu.cs590de.lab5.shopping.repository.ShoppingCartRepository;
import org.springframework.stereotype.Service;

import java.util.Optional;

/**
 * Implements IShoppingCart from the Part 1 component design.
 *
 * Loads the cart, asks the Product component for the product details, lets the
 * cart do the merging, saves. No business logic of its own.
 */
@Service
public class ShoppingService {

    private final ShoppingCartRepository shoppingCartRepository;
    private final ProductCatalogClient productCatalogClient;

    public ShoppingService(ShoppingCartRepository shoppingCartRepository,
                           ProductCatalogClient productCatalogClient) {
        this.shoppingCartRepository = shoppingCartRepository;
        this.productCatalogClient = productCatalogClient;
    }

    public ShoppingCart addToShoppingCart(String customerNumber, String productNumber, int quantity) {

        ProductCatalogClient.ProductView product = productCatalogClient.getProduct(productNumber);
        if (product == null) {
            throw new IllegalArgumentException("Unknown product: " + productNumber);
        }

        ShoppingCart cart = shoppingCartRepository.findById(customerNumber)
                .orElseGet(() -> new ShoppingCart(customerNumber));

        cart.addToCart(product.productNumber(), product.name(), product.price(), quantity);

        return shoppingCartRepository.save(cart);
    }

    public Optional<ShoppingCart> getShoppingCart(String customerNumber) {
        return shoppingCartRepository.findById(customerNumber);
    }
}
