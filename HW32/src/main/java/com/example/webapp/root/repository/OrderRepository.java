package com.example.webapp.root.repository;

import com.example.webapp.root.entity.Order;
import com.example.webapp.root.entity.Product;
import com.example.webapp.web.util.Util;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.*;
import java.util.concurrent.atomic.AtomicInteger;


@Repository
public class OrderRepository {

    private final List<Order> orders = new ArrayList<>();

    private final static AtomicInteger idCounter = new AtomicInteger(0);


    public Optional<Order> findById(Integer id) {
        for (Order o : orders) {
            if (!Objects.equals(o.getId(), id)) {
                continue;
            }
            return Optional.of(o);
        }
        return Optional.empty();
    }

    public List<Order> getAll() {
        return orders;
    }

    public boolean addOrder() {

        Integer generatedID = idCounter.incrementAndGet();
        List<Product> generatedProductList = Util.generateProductList();
        String orderCreateDate = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss").format(LocalDateTime.now());
        Integer allProductsCost = 0;
        for (Product p : generatedProductList) {
            allProductsCost += p.getCost();
        }
        return orders.add(new Order(generatedID, orderCreateDate, allProductsCost, generatedProductList));
    }
}
