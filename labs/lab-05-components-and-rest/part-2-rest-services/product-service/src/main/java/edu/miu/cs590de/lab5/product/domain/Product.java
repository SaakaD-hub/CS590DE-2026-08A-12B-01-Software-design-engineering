package edu.miu.cs590de.lab5.product.domain;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

/**
 * Entity. The product number is its identity, so it is used as the Mongo _id
 * rather than letting Mongo generate an ObjectId.
 */
@Document(collection = "product")
public class Product {

    @Id
    private String productNumber;

    private String name;
    private String description;
    private Money price;
    private Stock stock;

    protected Product() {
    }

    public Product(String productNumber, String name, String description, Money price, Stock stock) {
        this.productNumber = productNumber;
        this.name = name;
        this.description = description;
        this.price = price;
        this.stock = stock;
    }

    public boolean isAvailable(int quantity) {
        return stock != null && stock.isAvailable(quantity);
    }

    public String getProductNumber() {
        return productNumber;
    }

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }

    public Money getPrice() {
        return price;
    }

    public Stock getStock() {
        return stock;
    }

    @Override
    public String toString() {
        return String.format("Product{productNumber='%s', name='%s', description='%s', price=%s, stock=%s}",
                productNumber, name, description, price, stock);
    }
}
