package edu.miu.cs590de.lab5.shopping.domain;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

/**
 * Entity. One cart per customer, so the customer number is its identity.
 *
 * The business logic lives here, not in the service: adding a product that is
 * already in the cart merges into the existing line rather than creating a
 * second one.
 */
@Document(collection = "shoppingcart")
public class ShoppingCart {

    @Id
    private String customerNumber;

    private List<CartLine> cartLines = new ArrayList<>();

    protected ShoppingCart() {
    }

    public ShoppingCart(String customerNumber) {
        this.customerNumber = customerNumber;
    }

    public void addToCart(String productNumber, String productName, Money unitPrice, int quantity) {
        for (int i = 0; i < cartLines.size(); i++) {
            CartLine line = cartLines.get(i);
            if (line.getProductNumber().equals(productNumber)) {
                cartLines.set(i, line.withQuantity(line.getQuantity() + quantity));
                return;
            }
        }
        cartLines.add(new CartLine(productNumber, productName, unitPrice, quantity));
    }

    public Money computeTotal() {
        Money total = new Money(BigDecimal.ZERO, "USD");
        for (CartLine line : cartLines) {
            total = total.add(line.computeSubtotal());
        }
        return total;
    }

    public String getCustomerNumber() {
        return customerNumber;
    }

    public List<CartLine> getCartLines() {
        return cartLines;
    }

    public Money getTotal() {
        return computeTotal();
    }
}
