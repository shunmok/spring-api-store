package com.codewithmosh.store.dtos;

import lombok.Data;
import java.math.BigDecimal;

@Data
public class OrderItemDto {
    private OrderProductDto product;
    private Integer quantity;
    private BigDecimal totalPrice = BigDecimal.ZERO;

}
