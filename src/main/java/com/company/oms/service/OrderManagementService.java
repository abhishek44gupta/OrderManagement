package com.company.oms.service;

import com.company.oms.exception.ResourceNotFoundException;
import com.company.oms.model.Order;
import com.company.oms.model.OrderItem;
import com.company.oms.repository.OrderItemRepository;
import com.company.oms.repository.OrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class OrderManagementService {

    private final OrderRepository orderRepository;
    private final OrderItemRepository orderItemRepository;

    @Autowired
    public OrderManagementService(OrderRepository orderRepository, OrderItemRepository orderItemRepository) {
        this.orderRepository = orderRepository;
        this.orderItemRepository = orderItemRepository;
    }

    public Order saveOrder(Order order) {
        Order savedOrder = orderRepository.save(order);
        return savedOrder;
    }

    public List<Order> getAllOrders() {
        return orderRepository.findAll();
    }

    public OrderItem saveOrderItem(long orderId, OrderItem orderItem) {
        Order order = getOrder(orderId);
        orderItem.setOrder(order);
        return orderItemRepository.save(orderItem);
    }

    public Order getOrder(long orderId) {
        Optional<Order> order = orderRepository.findById(orderId);
        if (order.isEmpty()) {
            throw new ResourceNotFoundException("Order ID:" + orderId);
        }
        return order.get();
    }

    public Order updateOrder(Order order, Long orderId) {
        Order existingOrder = getOrder(orderId);
        order.setOrderId(existingOrder.getOrderId());
        Order saved = orderRepository.save(order);
        return saved;
    }

    public Order deleteOrder(Long orderId) {
        Order existingOrder = getOrder(orderId);
        orderRepository.delete(existingOrder);
        return existingOrder;
    }

    public OrderItem getOrderItem(Long orderId,
                                  Long orderItemId) {
        Order order = getOrder(orderId);
        Optional<OrderItem> orderItem = orderItemRepository.findById(orderItemId);
        if (orderItem.isEmpty()) {
            throw new ResourceNotFoundException("Order Item id:" + orderItemId);
        }
        return orderItem.get();
    }

    public List<OrderItem> getOrderItems(Long orderId) {
        Order order = getOrder(orderId);
        return orderItemRepository.findByOrder(order);
    }

    public OrderItem updateOrderItem(Long orderId,
                                     Long orderItemId,
                                     OrderItem orderItem) {
        OrderItem existingOrderItem = getOrderItem(orderId, orderItemId);
        orderItem.setOrderItemId(existingOrderItem.getOrderItemId());
        return orderItemRepository.save(orderItem);
    }

    public OrderItem deleteOrderItem(Long orderId,
                                     Long orderItemId) {
        OrderItem orderItem = getOrderItem(orderId, orderItemId);
        orderItemRepository.delete(orderItem);
        return orderItem;
    }

    public List<OrderItem> deleteOrderItems(Long orderId) {
        List<OrderItem> orderItems = getOrderItems(orderId);
        for (OrderItem orderItem : orderItems)
            orderItemRepository.delete(orderItem);
        return orderItems;
    }

}

