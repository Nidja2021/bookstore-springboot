package com.bookstore.order.dto;

import com.bookstore.book.Book;
import com.bookstore.order.OrderStatus;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class OrderResponseDto {
    private String user;
    private List<Book> books;

    @JsonProperty("order_date")
    private LocalDate orderDate;

    @JsonProperty("order_status")
    private OrderStatus orderStatus;
}
