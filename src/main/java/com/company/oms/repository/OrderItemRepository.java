package com.company.oms.repository;

import com.company.oms.model.Order;
import com.company.oms.model.OrderItem;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface OrderItemRepository extends JpaRepository<OrderItem,Long> {

    public List<OrderItem> findByOrder(Order order);
}
