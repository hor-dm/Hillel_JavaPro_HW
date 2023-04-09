package HW19;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Main {
    public static void main(String[] args) {
        List<Product> productList = new ArrayList<>();
        productList.add(new Product("Book", 50));
        productList.add(new Product("Book", 75));
        productList.add(new Product("Book", 74));
        productList.add(new Product("Book", 76));
        productList.add(new Product("Book", 80));
        productList.add(new Product("Magazine", 200));
        productList.add(new Product("Book", 100));
        productList.add(new Product("Magazine", 90));
        productList.add(new Product("Book", 251));
        productList.add(new Product("Magazine", 290));
        productList.add(new Product("Book", 250));
        productList.add(new Product("Magazine", 250));
        productList.add(new Product("Book", 300));
        productList.add(new Product("Book", 400, true));
        productList.add(new Product("Book", 500, true));
        productList.add(new Product("Book", 600, false));


        System.out.println("1.2 \"Book\" and  price > 250");
        printProductList(getProductList(productList, "Book"));

        System.out.println("2.2 \"Book\" and discount");
        printProductList(getProductListDisc(productList, "Book"));

        System.out.println("3.2 3.3 chipest product");
        Product minPriceProduct1 = getChipestProduct(productList, "Book");
        printProduct(minPriceProduct1);

        Product minPriceProduct2 = getChipestProduct(productList, "Newspaper");
        printProduct(minPriceProduct2);

        System.out.println("4.2 last 3 added by time");
        printProductList(getThreeLastAddedProducts(productList));

        System.out.println("5.2 this year and \"Book\" and price < 75");
        //2023 Book
        getTotalCostProducts(productList, "Book", "2023");
        //2022 Book
        getTotalCostProducts(productList, "Book", "2022");
        //2023 Magazine
        getTotalCostProducts(productList, "Magazine", "2023");
        //2022 Magazine
        getTotalCostProducts(productList, "Magazine", "2022");
        System.out.println();

        System.out.println("6.2 get Map");
        printMap(getGroupedProducts(productList));

    }

    public static void printProductList(List<Product> products) {
        for (Product p : products) {
            if (!p.getProductType().isBlank()) {
                System.out.println(p.getProductType() + " " + p.getPrice());
            }
        }
        System.out.println();
    }

    public static void printProduct(Product product) {
        if (!product.getProductType().isBlank()) {
            System.out.println(product.getProductType() + " " + product.getPrice());
        }
        System.out.println();
    }

    public static void printMap(Map<String, List<Product>> map){
        for (Map.Entry<String, List<Product>> entry : map.entrySet()) {
            System.out.println(entry.getKey());
            for (Product p : entry.getValue()) {
                System.out.println("Type: " + p.getProductType() + " Price: " + p.getPrice()
                        + " Discount: " + p.isHasDiscount() + " Create date: " + p.getAddDate());
            }
            System.out.println();
        }
    }

    public static List<Product> getProductList(List<Product> products, String product) {
        Stream<Product> productStream = products.stream();
        return productStream
                .filter(s -> s.getProductType().equals(product))
                .filter(s -> s.getPrice() > 250)
                .collect(Collectors.toList());
    }

    public static List<Product> getProductListDisc(List<Product> products, String product) {
        Stream<Product> productStream = products.stream();
        return productStream
                .filter(s -> s.getProductType().equals(product))
                .filter(Product::isHasDiscount)
                .map(s -> {
                    Product p = new Product(s.getProductType(), s.getPrice());
                    p.setPrice(s.getPrice() - (s.getPrice() * 0.1));
                    return p;
                })
                .collect(Collectors.toList());
    }

    public static Product getChipestProduct(List<Product> products, String product) {
        Product min;
        try {
            min = products.stream()
                    .filter(s -> s.getProductType().equals(product))
                    .min(Product::comparePrice).get();
            return min;
        } catch (Exception e) {
            System.out.println("Product " + product + " not found.");
            return new Product("", 0);
        }
    }

    public static List<Product> getThreeLastAddedProducts(List<Product> products) {
        return products.stream()
                .sorted(Comparator.comparing(Product::getAddDate))
                .skip((long) products.size() - 3)
                .collect(Collectors.toList());
    }

    public static void getTotalCostProducts(List<Product> products, String product, String year) {
        int result = products.stream()
                .filter(s -> s.getProductType().equals(product))
                .filter(s -> s.getAddDate().substring(4, 8).equals(year))
                .filter(s -> s.getPrice() < 75)
                .mapToInt(s -> (int) s.getPrice())
                .reduce(0, Integer::sum);
        System.out.println(result);
    }

    public static Map<String, List<Product>> getGroupedProducts(List<Product> products) {
        return products
                .stream()
                .collect(Collectors.groupingBy(Product::getProductType));
    }


}