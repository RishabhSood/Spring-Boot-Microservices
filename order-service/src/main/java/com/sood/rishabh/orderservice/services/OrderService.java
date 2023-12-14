package com.sood.rishabh.orderservice.services;

import com.sood.rishabh.orderservice.dto.OrderLineItemsDto;
import com.sood.rishabh.orderservice.dto.OrderRequestDto;
import com.sood.rishabh.orderservice.models.Order;
import com.sood.rishabh.orderservice.models.OrderLineItems;
import com.sood.rishabh.orderservice.repository.OrderRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.UUID;

@Service
@RequiredArgsConstructor
@Transactional
public class OrderService {
    private final OrderRepository orderRepository;
    public void placeOrder(OrderRequestDto orderRequestDto) {
        Order order = new Order();
        order.setOrderNumber(UUID.randomUUID().toString());
        List<OrderLineItems> orderLineItemsList = orderRequestDto.getOrderLineItemsDtoList()
                .stream()
                .map(this::mapOrderLineItemsDtoToModel)
                .toList();
        order.setOrderLineItemsList(orderLineItemsList);
        orderRepository.save(order);
    }

    private OrderLineItems mapOrderLineItemsDtoToModel(OrderLineItemsDto orderLineItemsDto) {
        OrderLineItems orderLineItems = new OrderLineItems();
        orderLineItems.setPrice(orderLineItemsDto.getPrice());
        orderLineItems.setQuantity(orderLineItemsDto.getQuantity());
        orderLineItems.setSkuCode(orderLineItemsDto.getSkuCode());
        return orderLineItems;
    }
}
