package esb;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.client.RestTemplate;

/**
 * Forwards the order to the international shipping service on port 8084.
 */
public class InternationalShippingActivator {

    @Autowired
    RestTemplate restTemplate;

    public void ship(Order order) {
        System.out.println("ESB -> international shipping : " + order);
        restTemplate.postForLocation("http://localhost:8084/orders", order);
    }
}
