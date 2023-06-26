package org.example.order;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.ArrayDeque;
import java.util.Arrays;

public class CoffeeOrderBoard {

    private static final Logger log = LoggerFactory.getLogger(CoffeeOrderBoard.class);

    ArrayDeque<Order> deque;
    private int lastOrderNumber;

    public CoffeeOrderBoard() {
        deque = new ArrayDeque<>();
    }

    public void add(String clientName) {
        deque.addLast(new Order(clientName, ++lastOrderNumber));

        log.info("Added client name: " + clientName);
    }

    public String deliver() {
        String result;
        Order order;
        order = deque.pollFirst();
        if (order != null) {
            result = "order from " + order.getClientName() + " number " + order.getOrderNumber() + " has been deleted";
        } else {
            result = "Order list is empty";
        }

        log.info("Deleted order: " + order);

        return result;
    }

    public String deliver(int orderNumber) {

        String result;
        Order order = new Order(null, 0);
        try {
            for (Order o : this.deque) {
                if (o.getOrderNumber() == orderNumber) {
                    order = o;
                }
            }
            if (this.deque.remove(order)) {
                result = "order deleted " + order.getClientName() + " " + order.getOrderNumber();

                log.info("Deleted order: " + order);
            } else {
                throw new Exception("Order" + orderNumber + " is missing");
            }
        } catch (Exception e) {
            log.error(e.getMessage() + " " + Arrays.toString(e.getStackTrace()));
            result = "their is no order with number " + orderNumber;
        }
        return result;
    }

    public void draw() {
        System.out.println("Number | Name");
        for (Order o : this.deque) {
            System.out.printf("%d\t\t| %s\n", o.getOrderNumber(), o.getClientName());
        }

        deque
                .stream()
                .map(o -> o.getOrderNumber() + ": " + o.getClientName())
                .forEach(log::info);
    }
}