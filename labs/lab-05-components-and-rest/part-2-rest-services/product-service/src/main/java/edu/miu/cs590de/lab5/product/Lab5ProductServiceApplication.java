package edu.miu.cs590de.lab5.product;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * CS590DE Lab 5 - Part 2
 * The Product component, exposed as a REST service and backed by MongoDB.
 *
 * @author David Kasozi Saaka
 */
@SpringBootApplication
public class Lab5ProductServiceApplication {

    public static void main(String[] args) {
        SpringApplication.run(Lab5ProductServiceApplication.class, args);
    }
}
