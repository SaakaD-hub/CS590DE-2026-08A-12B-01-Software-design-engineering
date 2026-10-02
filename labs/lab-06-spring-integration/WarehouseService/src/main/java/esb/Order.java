package esb;

/**
 * The message that travels through the ESB.
 *
 * orderType was added for part b of the lab. It is either "international" or
 * "domestic" and decides which router branch the order takes.
 *
 * The no-argument constructor is required: Jackson needs it to turn the
 * incoming JSON back into an Order.
 */
public class Order {

    private String orderNumber;
    private double amount;
    private String orderType;

    public Order() {
    }

    public Order(String orderNumber, double amount, String orderType) {
        this.orderNumber = orderNumber;
        this.amount = amount;
        this.orderType = orderType;
    }

    public String getOrderNumber() {
        return orderNumber;
    }

    public void setOrderNumber(String orderNumber) {
        this.orderNumber = orderNumber;
    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    public String getOrderType() {
        return orderType;
    }

    public void setOrderType(String orderType) {
        this.orderType = orderType;
    }

    @Override
    public String toString() {
        return String.format("Order{orderNumber='%s', amount=%.2f, orderType='%s'}",
                orderNumber, amount, orderType);
    }
}
