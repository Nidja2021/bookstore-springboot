package com.bookstore.order.dto;

import com.bookstore.book.Book;
import com.bookstore.order.OrderStatus;
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
public class OrderRequestDto {
    private List<Book> books;
    private LocalDate orderDate;
    private OrderStatus orderStatus;
}
