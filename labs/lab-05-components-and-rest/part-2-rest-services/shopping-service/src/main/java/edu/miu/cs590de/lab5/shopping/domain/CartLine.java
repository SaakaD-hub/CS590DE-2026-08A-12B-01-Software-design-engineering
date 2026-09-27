package edu.miu.cs590de.lab5.shopping.domain;

/**
 * Value object. Holds the product details as they were when the line was
 * added, plus the quantity.
 */
public class CartLine {

    private String productNumber;
    private String productName;
    private Money unitPrice;
    private int quantity;

    protected CartLine() {
    }

    public CartLine(String productNumber, String productName, Money unitPrice, int quantity) {
        this.productNumber = productNumber;
        this.productName = productName;
        this.unitPrice = unitPrice;
        this.quantity = quantity;
    }

    /** Value objects are immutable - changing the quantity produces a new line. */
    public CartLine withQuantity(int newQuantity) {
        return new CartLine(productNumber, productName, unitPrice, newQuantity);
    }

    public Money computeSubtotal() {
        return unitPrice.multiply(quantity);
    }

    public String getProductNumber() {
        return productNumber;
    }

    public String getProductName() {
        return productName;
    }

    public Money getUnitPrice() {
        return unitPrice;
    }

    public int getQuantity() {
        return quantity;
    }

    @Override
    public String toString() {
        return String.format("%-22s x%-3d @ %-12s = %s",
                productName, quantity, unitPrice, computeSubtotal());
    }
}
