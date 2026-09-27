package edu.miu.cs590de.lab4springmongo.domain;

/**
 * A student's address.
 *
 * A plain class with no annotation. MongoDB stores it as a nested
 * sub-document inside the student document, so the structure is kept
 * rather than flattened into separate fields.
 */
public class Address {

    private String street;
    private String city;
    private String zip;

    protected Address() {
        // required when Spring Data maps a document back to an object
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