package edu.miu.cs590de.lab5.shopping.web;

import edu.miu.cs590de.lab5.shopping.domain.ShoppingCart;
import edu.miu.cs590de.lab5.shopping.service.ShoppingService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

/**
 * The REST interface of the Shopping component - the network form of
 * IShoppingCart.
 *
 *   POST /api/carts/{customerNumber}/items   addToShoppingCart
 *   GET  /api/carts/{customerNumber}         getShoppingCart
 */
@RestController
@RequestMapping("/api/carts")
public class ShoppingController {

    private final ShoppingService shoppingService;

    public ShoppingController(ShoppingService shoppingService) {
        this.shoppingService = shoppingService;
    }

    @PostMapping("/{customerNumber}/items")
    public ShoppingCart addToShoppingCart(@PathVariable String customerNumber,
                                          @RequestBody AddToCartRequest request) {
        return shoppingService.addToShoppingCart(customerNumber,
                                                 request.productNumber(),
                                                 request.quantity());
    }

    @GetMapping("/{customerNumber}")
    public ResponseEntity<ShoppingCart> getShoppingCart(@PathVariable String customerNumber) {
        return shoppingService.getShoppingCart(customerNumber)
                .map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.notFound().build());
    }

    public record AddToCartRequest(String productNumber, int quantity) {
    }
}
