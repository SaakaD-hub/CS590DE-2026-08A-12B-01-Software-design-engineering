package esb;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.client.RestTemplate;

/**
 * Forwards the order to the next day shipping service on port 8083.
 */
public class NextDayShippingActivator {

    @Autowired
    RestTemplate restTemplate;

    public void ship(Order order) {
        System.out.println("ESB -> next day shipping : " + order);
        restTemplate.postForLocation("http://localhost:8083/orders", order);
    }
}
