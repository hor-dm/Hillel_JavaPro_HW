package com.example.webapp.web;

import com.example.webapp.root.entity.Order;
import com.example.webapp.root.repository.OrderService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/")
@RequiredArgsConstructor
public class OrderRestController {

    private final OrderService orderService;

    @GetMapping("/orders")
    public List<Order> orders() {
        return orderService.findAll();
    }


    @GetMapping("/{id}")
    public Order getOrderByID(@PathVariable("id") Integer id){
        return orderService
                .findById(id)
                .orElseThrow(()->new IllegalArgumentException("no order with id = " + id));
    }

    @GetMapping("/create")
    public String create() {
        if (orderService.addOrder()){
            return "Random order created with random list of products";
        } else {
            return "Something goes wrong";
        }
    }
}
