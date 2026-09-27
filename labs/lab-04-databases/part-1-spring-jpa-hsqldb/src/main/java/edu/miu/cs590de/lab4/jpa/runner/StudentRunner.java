package edu.miu.cs590de.lab4.jpa.runner;

import edu.miu.cs590de.lab4.jpa.domain.Address;
import edu.miu.cs590de.lab4.jpa.domain.Student;
import edu.miu.cs590de.lab4.jpa.repository.StudentRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * Adds 5 students to the database, then runs the four queries required by the
 * lab and prints the results to the console.
 */
@Component
public class StudentRunner implements CommandLineRunner {

    private final StudentRepository studentRepository;

    public StudentRunner(StudentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }

    @Override
    public void run(String... args) {

        addFiveStudents();

        heading("1. Get all students");
        studentRepository.findAll().forEach(System.out::println);

        heading("2. Get all students with the name 'John'");
        studentRepository.findByName("John").forEach(System.out::println);

        heading("3. Get the student with phone number '5085555555'");
        studentRepository.findByPhoneNumber("5085555555")
                .ifPresentOrElse(System.out::println,
                                 () -> System.out.println("No student found with that phone number"));

        heading("4. Get all students from Boston");
        studentRepository.findByAddressCity("Boston").forEach(System.out::println);

        System.out.println("\nDone. Open the HSQL Database Manager and run:  SELECT * FROM STUDENT");
    }

    private void addFiveStudents() {
        List<Student> students = List.of(
            new Student("David", "6171111111", "david@email.com",
                        new Address("10 Main Street", "Boston", "02110")),
            new Student("John",  "6172222222", "john@email.com",
                        new Address("20 Main Street", "Boston", "02110")),
            new Student("John",  "6173333333", "john.smith@email.com",
                        new Address("30 Elm Street", "Cambridge", "02139")),
            new Student("Sarah", "5085555555", "sarah@email.com",
                        new Address("50 Main Street", "Worcester", "01608")),
            new Student("Mary",  "7814444444", "mary@email.com",
                        new Address("12 Oak Street", "Boston", "02114"))
        );

        studentRepository.saveAll(students);
        System.out.println("\nSaved " + students.size() + " students to HSQLDB.");
    }

    private void heading(String title) {
        System.out.println("\n=================================================================");
        System.out.println(title);
        System.out.println("=================================================================");
    }
}