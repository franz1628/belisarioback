package com.pruebas.backbelisario.service;

import com.pruebas.backbelisario.model.Order;
import com.pruebas.backbelisario.model.OrderItem;
import com.pruebas.backbelisario.model.Product;
import com.pruebas.backbelisario.repository.OrderRepository;
import com.pruebas.backbelisario.repository.ProductRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class OrderService {
    private final OrderRepository orderRepository;
    private final ProductRepository productRepository;

    @Transactional
    public Order createOrder(Order order) {
        for (OrderItem item : order.getItems()) {
            item.setOrder(order);
            Product p = productRepository.findById(item.getProduct().getId())
                    .orElseThrow(() -> new RuntimeException("Product not found"));
            item.setPrice(p.getPrice());
        }
        return orderRepository.save(order);
    }
}
