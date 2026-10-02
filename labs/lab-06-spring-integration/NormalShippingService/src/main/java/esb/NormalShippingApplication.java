package esb;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * CS590DE Lab 6 - NORMAL SHIPPING service, listening on port 8082.
 *
 * @author David Kasozi Saaka
 */
@SpringBootApplication
public class NormalShippingApplication {

    public static void main(String[] args) {
        SpringApplication.run(NormalShippingApplication.class, args);
    }
}
