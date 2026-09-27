package edu.miu.cs590de.lab4.jpa.repository;

import edu.miu.cs590de.lab4.jpa.domain.Student;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

/**
 * The four queries required by the lab.
 *
 * Spring Data derives the SQL from the method names, so no query needs to be
 * written by hand. findByAddressCity reaches into the embedded Address to
 * filter on its city column.
 */
public interface StudentRepository extends JpaRepository<Student, Long> {

    // 2. Get all students with a certain name
    List<Student> findByName(String name);

    // 3. Get a student with a certain phoneNumber
    Optional<Student> findByPhoneNumber(String phoneNumber);

    // 4. Get all students from a certain city
    List<Student> findByAddressCity(String city);

    // 1. Get all students -> findAll(), inherited from JpaRepository
}