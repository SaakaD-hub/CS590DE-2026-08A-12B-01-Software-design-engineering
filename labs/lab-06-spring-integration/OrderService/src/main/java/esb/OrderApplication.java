package esb;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.client.RestTemplate;

import java.util.List;

/**
 * CS590DE Lab 6 - sends a set of test orders into the ESB on port 8080.
 *
 * The four orders are chosen so that every branch of both routers is taken:
 *
 *   334  domestic       120.00  -> router 1 domestic, router 2 normal
 *   355  domestic       185.00  -> router 1 domestic, router 2 next day
 *   401  international   90.00  -> router 1 international (amount ignored)
 *   402  international  300.00  -> router 1 international (amount ignored)
 *
 * The last one matters: it proves order type is checked before amount, so a
 * 300 dollar international order does not end up in next day shipping.
 *
 * @author David Kasozi Saaka
 */
@SpringBootApplication
public class OrderApplication implements CommandLineRunner {

    private static final String ESB_URL = "http://localhost:8080/orders";

    private final RestTemplate restTemplate;

    public OrderApplication(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    public static void main(String[] args) {
        SpringApplication.run(OrderApplication.class, args);
    }

    @Override
    public void run(String... args) {

        List<Order> orders = List.of(
                new Order("334", 120.0, "domestic"),
                new Order("355", 185.0, "domestic"),
                new Order("401",  90.0, "international"),
                new Order("402", 300.0, "international")
        );

        for (Order order : orders) {
            System.out.println("sending " + order);
            restTemplate.postForLocation(ESB_URL, order);
        }

        System.out.println("\nAll " + orders.size()
                + " orders sent. Check the console of each service.");
    }
}