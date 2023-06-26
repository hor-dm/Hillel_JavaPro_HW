package org.example;

import org.example.models.Cart;
import org.example.utils.Utils;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        AnnotationConfigApplicationContext context =
                new AnnotationConfigApplicationContext("org.example.models");

        Scanner scanner = new Scanner(System.in);
        Cart cart = context.getBean(Cart.class);
        boolean isExit = false;
        while (!isExit) {
            System.out.println("1 - add product, 2 - remove product, 3 - new cart, 4 - exit");

            switch (scanner.nextInt()) {
                case 1 -> {
                    System.out.println("\nEnter product ID to add:");
                    Utils.printProductInfo(context);
                    int selectedProduct = scanner.nextInt();
                    if (Utils.enterAndCheckID(selectedProduct, context)) {
                        cart.addProductToChart(selectedProduct);
                    }
                    cart.getAll();
                }
                case 2 -> {
                    cart.getAll();
                    System.out.println("\nEnter product ID to remove:");
                    Utils.printProductInfo(context);

                    int selectedProduct = scanner.nextInt();

                    if (Utils.enterAndCheckID(selectedProduct, context)) {
                        cart.removeProduct(selectedProduct);
                    }
                    cart.getAll();
                }
                case 3 -> {
                    System.out.println("new cart is created");
                    cart = context.getBean(Cart.class);
                    cart.getAll();
                }
                case 4 -> isExit = true;
            }
        }
        scanner.close();
    }
}