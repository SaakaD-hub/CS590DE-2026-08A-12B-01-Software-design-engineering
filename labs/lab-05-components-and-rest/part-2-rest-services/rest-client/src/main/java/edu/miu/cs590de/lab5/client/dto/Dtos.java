package edu.miu.cs590de.lab5.client.dto;

import java.math.BigDecimal;
import java.util.List;

/**
 * What the client sends and receives. These are deliberately its own types:
 * the client talks to the services over HTTP and must not share classes with
 * them, otherwise the components stop being independent.
 */
public final class Dtos {

    private Dtos() {
    }

    public record Money(BigDecimal amount, String currency) {
        @Override
        public String toString() {
            return amount + " " + currency;
        }
    }

    public record Stock(int nrInStock, String locationCode) {
    }

    public record Product(String productNumber,
                          String name,
                          String description,
                          Money price,
                          Stock stock) {
    }

    public record AddToCartRequest(String productNumber, int quantity) {
    }

    public record CartLine(String productNumber,
                           String productName,
                           Money unitPrice,
                           int quantity) {
    }

    public record ShoppingCart(String customerNumber,
                               List<CartLine> cartLines,
                               Money total) {
    }
}
