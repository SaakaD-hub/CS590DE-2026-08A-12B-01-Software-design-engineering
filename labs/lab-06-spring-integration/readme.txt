CS590DE Lab 6 - Spring Integration
David Kasozi Saaka


a) STATUS OF THE LAB
--------------------
All parts of the lab are finished.

Part a - two shipping services, split on amount.
  Implemented. A router (esb.AmountRouter) reads the order amount and sends
  orders of more than 175 dollars to the next day shipping service and all
  other orders to the normal shipping service.

Part b - an extra international shipping service and a second router.
  Implemented. An extra field "orderType" was added to Order, with the values
  "international" and "domestic". There are two routers:

    Router 1  esb.OrderTypeRouter  checks the order type first. International
                                   orders go straight to the international
                                   shipping service.
    Router 2  esb.AmountRouter     only receives domestic orders and splits
                                   them on amount as described in part a.

Nothing is unfinished.

Projects in this zip:
  EnterpriseServiceBus          port 8080   channels, routers, activators
  WarehouseService              port 8081
  NormalShippingService         port 8082
  NextDayShippingService        port 8083
  InternationalShippingService  port 8084
  OrderService                  sends four test orders into the ESB

How to run:
  1. Start EnterpriseServiceBus, WarehouseService, NormalShippingService,
     NextDayShippingService and InternationalShippingService.
  2. Run OrderService. It sends four orders, one for every branch of the two
     routers, and each service prints the orders it receives.

Note on the boundary value: the assignment says "more than 175 dollars" for
next day and "below 175 dollars" for normal, which leaves exactly 175
undefined. An order of exactly 175 is handled by the normal shipping service.


b) DECLARATION
--------------
I hereby declare that this submission is my own original work and to the best
of my knowledge it contains no materials previously published or written by
another person. I am aware that submitting solutions that are not my own work
will result in an NC of the course.

I am aware that I am not allowed to share solutions with other students.

I am aware that if I submit only parts of this lab that points will be
subtracted.

I am aware that if my lab submission does not contain this readme.txt file
that I do not get points for this lab.

David Kasozi Saaka
