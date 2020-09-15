package com.company.oms.controller;

import com.company.oms.dto.OrderItemDto;
import com.company.oms.model.Order;
import com.company.oms.model.OrderItem;
import com.company.oms.service.OrderManagementService;
import com.company.oms.util.DtoConversionUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/oms/v1")
public class OrderManagementController {
    private static Logger logger = LoggerFactory.getLogger(OrderManagementController.class);

    private final OrderManagementService orderManagementService;

    @Autowired
    public OrderManagementController(OrderManagementService orderManagementService) {
        this.orderManagementService = orderManagementService;
    }

    @PostMapping(path = "/order")
    @ResponseStatus(HttpStatus.CREATED)
    public Order savOrder(@RequestBody Order order) {
        logger.info("saving order : {}", order);
        return orderManagementService.saveOrder(order);
    }

    @PostMapping(path = "/order/{orderId}/orderItem")
    @ResponseStatus(HttpStatus.CREATED)
    public OrderItemDto savOrder(@PathVariable(name = "orderId") long orderId, @RequestBody OrderItem orderItem) {
        logger.info("saving orderitem for orederId : ", orderId);
        return DtoConversionUtils.convetOrderItemToDto(orderManagementService.saveOrderItem(orderId, orderItem));
    }

    @GetMapping(path = "/orders")
    @ResponseStatus(HttpStatus.OK)
    public List<Order> getAllOrders() {
        logger.info("getting all orders");
        return orderManagementService.getAllOrders();
    }

    @GetMapping(path = "/order/{orderid}")
    @ResponseBody
    @ResponseStatus(HttpStatus.OK)
    public Order getOrder(@PathVariable(name = "orderId") Long orderId) {
        logger.info("geting order, orderId : {}", orderId);
        return orderManagementService.getOrder(orderId);
    }

    @PutMapping(path = "/order/{orderId}")
    @ResponseStatus(HttpStatus.OK)
    public Order updateOrder(@RequestBody Order order, @PathVariable(name = "orderId") Long orderId) {
        logger.info("updating order for orderId  {} and order {}", orderId, order);
        return orderManagementService.updateOrder(order, orderId);
    }

    @DeleteMapping(path = "/order/{orderId}")
    @ResponseStatus(HttpStatus.OK)
    public Order deleteOrder(@PathVariable(name = "orderId") Long orderId) {
        logger.info("delete order : {}", orderId);
        return orderManagementService.deleteOrder(orderId);
    }


    @GetMapping(path = "/order/{orderId}/orderItem/{orderItemId}")
    @ResponseStatus(HttpStatus.OK)
    public OrderItemDto getOrderItem(@PathVariable(name = "orderId") Long orderId,
                                  @PathVariable(name = "orderItemId") Long orderItemId) {
        logger.info("getting orderitem for  order {} and orderItem {}", orderId, orderItemId);
        return DtoConversionUtils.convetOrderItemToDto(orderManagementService.getOrderItem(orderId, orderItemId));
    }

    @GetMapping(path = "/order/{orderId}/orderItems")
    @ResponseStatus(HttpStatus.OK)
    public List<OrderItemDto> getOrderItems(@PathVariable(name = "orderId") Long orderId) {
        logger.info("getting orderitems for  orderId {} ", orderId);
        return DtoConversionUtils.convetOrderItemsToDtos(orderManagementService.getOrderItems(orderId));
    }

    @PutMapping(path = "/order/{orderId}/orderItem")
    @ResponseStatus(HttpStatus.CREATED)
    public OrderItem saveOrderItem(@PathVariable(name = "orderId") Long orderId,
                                     @PathVariable(name = "orderItemId") Long orderItemId,
                                     @RequestBody OrderItem orderItem) throws Exception {
        logger.info("updating orderitems for  orderId {} and orderitem id {}", orderId, orderItemId);
        return orderManagementService.updateOrderItem(orderId, orderItemId, orderItem);
    }

    @PutMapping(path = "/order/{orderId}/orderItem/{orderItemId}")
    @ResponseStatus(HttpStatus.OK)
    public OrderItem updateOrderItem(@PathVariable(name = "orderId") Long orderId,
                                     @PathVariable(name = "orderItemId") Long orderItemId,
                                     @RequestBody OrderItem orderItem) throws Exception {
        logger.info("updating orderitems for  orderId {} and orderitem id {}", orderId, orderItemId);
        return orderManagementService.updateOrderItem(orderId, orderItemId, orderItem);
    }

    @DeleteMapping(path = "/order/{orderId}/orderItem/{orderItemId}")
    @ResponseStatus(HttpStatus.OK)
    public OrderItem deleteOrderItem(@PathVariable(name = "orderId") Long orderId,
                                     @PathVariable(name = "orderItemId") Long orderItemId) {
        logger.info("deleting orderitems for  orderId {} and orderitem id {}", orderId, orderItemId);
        return orderManagementService.deleteOrderItem(orderId, orderItemId);
    }

    @DeleteMapping(path = "/order/{orderId}/orderItems")
    @ResponseStatus(HttpStatus.OK)
    public List<OrderItem> deleteOrderItems(@PathVariable(name = "orderId") Long orderId) {
        logger.info("deleting all orderitems for  orderId {}", orderId);
        return orderManagementService.deleteOrderItems(orderId);
    }
}
