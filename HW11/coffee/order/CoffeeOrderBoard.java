package coffee.order;

import java.util.ArrayDeque;
import java.util.Objects;

public class CoffeeOrderBoard {

    ArrayDeque<coffee.order.Order> deque;
    private int lastOrderNumber;

    public CoffeeOrderBoard() {
        deque = new ArrayDeque<>();
    }

    public void add(String s) {
        deque.addLast(new coffee.order.Order(s, ++lastOrderNumber));
    }

    public String deliver() {
        String result;
        coffee.order.Order o;
        o = deque.pollFirst();
        result = "order deleted " + Objects.requireNonNull(o).getClientName() + " " + o.getOrderNumber();
        return result;
    }

    public String deliver(int num) {
        String result;
        coffee.order.Order o = new coffee.order.Order(null, 0);
        // цикл ищет объект у которого номер = переданной переменной num
        for (coffee.order.Order order : this.deque) {
            if (order.getOrderNumber() == num) {
                o = order;
            }
        }
        result = "order deleted " +  o.getClientName() + " " + o.getOrderNumber();
        if (o.getClientName() == null) {
            return "their is no order with number " + num + "\n";
        }
        this.deque.remove(o);
        return result;
    }

    public void draw() {
        System.out.println("Number | Name");
        for (coffee.order.Order o : this.deque) {
            System.out.printf("%d\t\t| %s\n", o.getOrderNumber(), o.getClientName());
        }
    }


}