package esb;

/**
 * Router 2 (part a of the lab).
 *
 * Only sees domestic orders, because router 1 has already taken the
 * international ones out. Orders of more than 175 dollars are shipped next
 * day, the rest go by normal shipping.
 *
 * An order of exactly 175 is neither "more than 175" nor "below 175" in the
 * assignment text, so it is treated as normal shipping.
 */
public class AmountRouter {

    public static final double NEXT_DAY_THRESHOLD = 175.0;

    public String route(Order order) {
        if (order.getAmount() > NEXT_DAY_THRESHOLD) {
            System.out.println("router 2 (amount)       : " + order.getAmount()
                    + " > " + NEXT_DAY_THRESHOLD + " -> nextdaychannel");
            return "nextdaychannel";
        }
        System.out.println("router 2 (amount)       : " + order.getAmount()
                + " <= " + NEXT_DAY_THRESHOLD + " -> normalchannel");
        return "normalchannel";
    }
}
