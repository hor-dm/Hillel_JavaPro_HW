package coffee.order;

public class Main {
    public static void main(String[] args) {


        coffee.order.CoffeeOrderBoard orderBoard = new coffee.order.CoffeeOrderBoard();
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

    static void printDeque(coffee.order.CoffeeOrderBoard cbo){
        for (coffee.order.Order o: cbo.deque){
            System.out.println(o.getOrderNumber() + " " + o.getClientName());
        }
    }
}