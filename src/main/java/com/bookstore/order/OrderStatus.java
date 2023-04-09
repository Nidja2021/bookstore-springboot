package com.bookstore.order;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum OrderStatus {
    PENDING("Pending"),
    SHIPPED("Shipped"),
    CANCELLED("Cancelled");

    private final String displayValue;
}
