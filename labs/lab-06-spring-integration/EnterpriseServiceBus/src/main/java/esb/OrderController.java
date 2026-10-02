package esb;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.messaging.Message;
import org.springframework.messaging.MessageChannel;
import org.springframework.messaging.support.MessageBuilder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

/**
 * The way into the bus. Accepts an order over REST and puts it on the first
 * channel; from there the XML configuration decides where it goes.
 */
@RestController
public class OrderController {

    @Autowired
    @Qualifier("warehousechannel")
    MessageChannel warehouseChannel;

    @PostMapping("/orders")
    public ResponseEntity<?> receiveOrder(@RequestBody Order order) {
        System.out.println("ESB received: " + order);
        Message<Order> orderMessage = MessageBuilder.withPayload(order).build();
        warehouseChannel.send(orderMessage);
        return new ResponseEntity<Order>(order, HttpStatus.OK);
    }
}
