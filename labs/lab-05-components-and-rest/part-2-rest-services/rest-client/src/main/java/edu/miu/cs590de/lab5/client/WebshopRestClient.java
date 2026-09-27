package edu.miu.cs590de.lab5.client;

import edu.miu.cs590de.lab5.client.dto.Dtos;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestClient;

import java.math.BigDecimal;

/**
 * Runs the four steps the lab asks for:
 *
 *   1. Add a new product to the product component
 *   2. Get the product back and print it
 *   3. Add that product to the shopping cart
 *   4. Get the shopping cart and print it
 */
@Component
public class WebshopRestClient implements CommandLineRunner {

    private static final String PRODUCT_NUMBER  = "A546";
    private static final String CUSTOMER_NUMBER = "C1001";
    private static final int    QUANTITY        = 2;

    private final RestClient productService;
    private final RestClient shoppingService;

    public WebshopRestClient(@Value("${productservice.base-url}") String productBaseUrl,
                             @Value("${shoppingservice.base-url}") String shoppingBaseUrl) {
        this.productService  = RestClient.create(productBaseUrl);
        this.shoppingService = RestClient.create(shoppingBaseUrl);
    }

    @Override
    public void run(String... args) {

        // ---- 1. Add a new product to the product component ----
        heading("1. Add a new product to the product component");

        Dtos.Product newProduct = new Dtos.Product(
                PRODUCT_NUMBER,
                "IPhone 12",
                "Apple iPhone 12, 128 GB, black",
                new Dtos.Money(new BigDecimal("980.00"), "USD"),
                new Dtos.Stock(25, "WH-A-12"));

        Dtos.Product created = productService.post()
                .uri("/api/products")
                .body(newProduct)
                .retrieve()
                .body(Dtos.Product.class);

        System.out.println("POST /api/products -> created " + created.productNumber());

        // ---- 2. Get the product and print it ----
        heading("2. Get the product from the product component");

        Dtos.Product fetched = productService.get()
                .uri("/api/products/{productNumber}", PRODUCT_NUMBER)
                .retrieve()
                .body(Dtos.Product.class);

        System.out.println("productNumber : " + fetched.productNumber());
        System.out.println("name          : " + fetched.name());
        System.out.println("description   : " + fetched.description());
        System.out.println("price         : " + fetched.price());
        System.out.println("stock         : " + fetched.stock().nrInStock()
                                              + " at " + fetched.stock().locationCode());

        // ---- 3. Add the product to the shopping cart ----
        heading("3. Add this product to the shopping cart");

        shoppingService.post()
                .uri("/api/carts/{customerNumber}/items", CUSTOMER_NUMBER)
                .body(new Dtos.AddToCartRequest(PRODUCT_NUMBER, QUANTITY))
                .retrieve()
                .body(Dtos.ShoppingCart.class);

        System.out.println("POST /api/carts/" + CUSTOMER_NUMBER + "/items -> added "
                           + QUANTITY + " x " + PRODUCT_NUMBER);

        // ---- 4. Get the shopping cart and print it ----
        heading("4. Get the shopping cart from the shopping component");

        Dtos.ShoppingCart cart = shoppingService.get()
                .uri("/api/carts/{customerNumber}", CUSTOMER_NUMBER)
                .retrieve()
                .body(Dtos.ShoppingCart.class);

        System.out.println("customer: " + cart.customerNumber());
        for (Dtos.CartLine line : cart.cartLines()) {
            System.out.printf("  %-10s %-22s x%-3d @ %-12s%n",
                    line.productNumber(), line.productName(), line.quantity(), line.unitPrice());
        }
        System.out.println("  total : " + cart.total());

        System.out.println("\nDone.");
    }

    private void heading(String title) {
        System.out.println("\n=================================================================");
        System.out.println(title);
        System.out.println("=================================================================");
    }
}
