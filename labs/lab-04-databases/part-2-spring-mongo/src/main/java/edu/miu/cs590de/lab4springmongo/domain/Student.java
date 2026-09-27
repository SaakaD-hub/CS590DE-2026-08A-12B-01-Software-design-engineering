package edu.miu.cs590de.lab4springmongo.domain;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

/**
 * A student, stored as one document in the "student" collection.
 */
@Document(collection = "student")
public class Student {

    @Id
    private String id;

    private String name;
    private String phoneNumber;
    private String email;

    private Address address;

    protected Student() {
        // required when Spring Data maps a document back to an object
    }

    public Student(String name, String phoneNumber, String email, Address address) {
        this.name = name;
        this.phoneNumber = phoneNumber;
        this.email = email;
        this.address = address;
    }

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public String getEmail() {
        return email;
    }

    public Address getAddress() {
        return address;
    }

    @Override
    public String toString() {
        return String.format("Student{id='%s', name='%s', phoneNumber='%s', email='%s', address=%s}",
                id, name, phoneNumber, email, address);
    }
}