package esb;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.client.RestTemplate;

/**
 * Forwards the order to the normal shipping service on port 8082.
 */
public class NormalShippingActivator {

    @Autowired
    RestTemplate restTemplate;

    public void ship(Order order) {
        System.out.println("ESB -> normal shipping : " + order);
        restTemplate.postForLocation("http://localhost:8082/orders", order);
    }
}
