package esb;

/**
 * Router 1 (part b of the lab).
 *
 * Looks at the order type only. International orders go straight to the
 * international shipping service; everything else is passed to router 2,
 * which decides between next day and normal shipping.
 *
 * The method returns the NAME of the channel to send the message to.
 */
public class OrderTypeRouter {

    public static final String INTERNATIONAL = "international";

    public String route(Order order) {
        if (INTERNATIONAL.equalsIgnoreCase(order.getOrderType())) {
            System.out.println("router 1 (order type)   : international -> internationalchannel");
            return "internationalchannel";
        }
        System.out.println("router 1 (order type)   : domestic      -> domesticchannel");
        return "domesticchannel";
    }
}
