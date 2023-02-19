package coffee.order;

public class Order {

    private final int orderNumber;
    private final String clientName;

    public Order(String clientName, int orderNumber) {
        this.clientName = clientName;
        this.orderNumber = orderNumber;
    }

    public int getOrderNumber() {
        return orderNumber;
    }

    public String getClientName() {
        return clientName;
    }
}