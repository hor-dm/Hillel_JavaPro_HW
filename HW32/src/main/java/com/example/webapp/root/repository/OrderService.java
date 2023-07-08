package com.example.webapp.root.repository;

import com.example.webapp.root.entity.Order;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class OrderService {

    private final OrderRepository orderRepository;

    public Optional<Order> findById(Integer id) {
        return this.orderRepository.findById(id);
    }

    public List<Order> findAll(){
        return this.orderRepository.getAll();
    }

    public boolean addOrder(){
        return this.orderRepository.addOrder();
    }

}
