package org.example.order;

public class Main {
    public static void main(String[] args) {


        CoffeeOrderBoard orderBoard = new CoffeeOrderBoard();
        orderBoard.add("Tom");
        orderBoard.add("Bob");
        orderBoard.add("Bill");

        System.out.println("\norder list :");
        printDeque(orderBoard);

        System.out.println("\noldest order, first order (ready)");
        System.out.println(orderBoard.deliver());

        System.out.println("\norder list :");
        printDeque(orderBoard);

        System.out.println("\nadd new orders: John and Alice");
        orderBoard.add("John");
        orderBoard.add("Alice");

        System.out.println("\norder list :");
        printDeque(orderBoard);

        System.out.println("\ndelete order #3");
        System.out.println((orderBoard.deliver(3)));

        System.out.println("\norder list :");
        printDeque(orderBoard);

        System.out.println("\ntry delete non-existent order #10");
        System.out.println((orderBoard.deliver(10)));

        System.out.println("\ndraw()");
        orderBoard.draw();
    }

    static void printDeque(CoffeeOrderBoard coffeeOrderBoard){
        for (Order o: coffeeOrderBoard.deque){
            System.out.println(o.getOrderNumber() + " " + o.getClientName());
        }
    }
}