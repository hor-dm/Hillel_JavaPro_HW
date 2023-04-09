package HW19;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class Product {
    private final String productType;
    private double price;
    private boolean hasDiscount;
    private final String addDate;

    public Product(String productType, double price) {
        this.productType = productType;
        this.price = price;
        this.addDate = setDateTime();
    }

    public Product(String productType, double price, boolean hasDiscount) {
        this.productType = productType;
        this.price = price;
        this.hasDiscount = hasDiscount;
        this.addDate = setDateTime();
    }

    public String getProductType() {
        return productType;
    }

    public double getPrice() {
        return price;
    }

    public String getAddDate() {
        return addDate;
    }

    public boolean isHasDiscount() {
        return hasDiscount;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public static int comparePrice(Product p1, Product p2){
        if(p1.getPrice() > p2.getPrice())
            return 1;
        return -1;
    }

    private String setDateTime(){
        LocalDateTime localDateTime = LocalDateTime.now();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("ddMMyyyyhhmmss");
        return localDateTime.format(formatter);
    }

}
