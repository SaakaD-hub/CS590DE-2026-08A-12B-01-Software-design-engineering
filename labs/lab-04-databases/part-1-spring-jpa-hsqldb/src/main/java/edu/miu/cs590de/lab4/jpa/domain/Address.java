package edu.miu.cs590de.lab4.jpa.domain;

import jakarta.persistence.Embeddable;

/**
 * A student's address.
 *
 * Mapped as @Embeddable rather than as its own entity: an address has no
 * identity of its own and only exists as part of a student, so its columns
 * live in the STUDENT table.
 */
@Embeddable
public class Address {

    private String street;
    private String city;
    private String zip;

    protected Address() {
        // required by JPA
    }

    public Address(String street, String city, String zip) {
        this.street = street;
        this.city = city;
        this.zip = zip;
    }

    public String getStreet() {
        return street;
    }

    public String getCity() {
        return city;
    }

    public String getZip() {
        return zip;
    }

    @Override
    public String toString() {
        return street + ", " + city + " " + zip;
    }
}