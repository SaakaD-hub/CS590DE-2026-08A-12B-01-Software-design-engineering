package edu.miu.cs590de.lab4springmongo.repository;


import edu.miu.cs590de.lab4springmongo.domain.Student;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;
import java.util.Optional;

/**
 * The four queries required by the lab.
 *
 * Spring Data builds the Mongo query from the method name, exactly as it
 * builds SQL in the JPA version. findByAddressCity becomes the query
 * { "address.city" : ... } because address is a nested sub-document.
 */
public interface StudentRepository extends MongoRepository<Student, String> {

    // 2. Get all students with a certain name
    List<Student> findByName(String name);

    // 3. Get a student with a certain phoneNumber
    Optional<Student> findByPhoneNumber(String phoneNumber);

    // 4. Get all students from a certain city
    List<Student> findByAddressCity(String city);

    // 1. Get all students -> findAll(), inherited from MongoRepository
}