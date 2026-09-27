package edu.miu.cs590de.lab5.product.domain;

/**
 * Value object holding the stock information for a product.
 */
public class Stock {

    private int nrInStock;
    private String locationCode;

    protected Stock() {
    }

    public Stock(int nrInStock, String locationCode) {
        this.nrInStock = nrInStock;
        this.locationCode = locationCode;
    }

    public boolean isAvailable(int quantity) {
        return nrInStock >= quantity;
    }

    public int getNrInStock() {
        return nrInStock;
    }

    public String getLocationCode() {
        return locationCode;
    }

    @Override
    public String toString() {
        return nrInStock + " at " + locationCode;
    }
}
