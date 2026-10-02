package esb;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.client.RestTemplate;

/**
 * Every order passes through the warehouse before it is shipped.
 * Returning the order puts it back on the output channel, which is where
 * router 1 picks it up.
 */
public class WarehouseActivator {

    @Autowired
    RestTemplate restTemplate;

    public Order checkStock(Order order) {
        System.out.println("ESB -> warehouse        : " + order);
        restTemplate.postForLocation("http://localhost:8081/orders", order);
        return order;
    }
}
