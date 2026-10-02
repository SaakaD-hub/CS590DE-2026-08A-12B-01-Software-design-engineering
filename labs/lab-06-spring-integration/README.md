# Lab 6 — Spring Integration

An enterprise service bus routing orders to a warehouse service and then to one of three shipping
services. Two routers decide the destination: the first on order type, sending international
orders to the international shipping service, the second on amount, splitting domestic orders
above and below 175 dollars between next day and normal shipping.
