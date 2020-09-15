package com.company.oms.util;

import com.company.oms.dto.OrderItemDto;
import com.company.oms.model.Order;
import com.company.oms.model.OrderItem;
import org.springframework.data.domain.jaxb.SpringDataJaxb;
import org.springframework.lang.NonNull;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class DtoConversionUtils {

    public static OrderItemDto convetOrderItemToDto(@NonNull OrderItem orderItem){
        if(orderItem == null){
            return new OrderItemDto();
        }
        OrderItemDto orderItemDto = new OrderItemDto();
        orderItemDto.setOrderId(orderItem.getOrder().getOrderId());
        orderItemDto.setOrderItemId(orderItem.getOrderItemId());
        orderItemDto.setQuantity(orderItem.getQuantity());
        orderItemDto.setProductCode(orderItem.getProductCode());
        orderItemDto.setProductName(orderItem.getProductName());
        return orderItemDto;
    }

    public static List<OrderItemDto> convetOrderItemsToDtos(@NonNull List<OrderItem> orderItems){
        if(orderItems.isEmpty()){
            Collections.emptyList();
        }
        List<OrderItemDto> orderItemDtos= new ArrayList<>();
        for(OrderItem orderItem : orderItems) {
            orderItemDtos.add(convetOrderItemToDto(orderItem));
        }
        return orderItemDtos;
    }
}
