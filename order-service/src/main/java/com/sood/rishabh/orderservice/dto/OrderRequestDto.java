package com.sood.rishabh.orderservice.dto;

import com.sood.rishabh.orderservice.models.OrderLineItems;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class OrderRequestDto {
    private List<OrderLineItemsDto> orderLineItemsDtoList;
}
