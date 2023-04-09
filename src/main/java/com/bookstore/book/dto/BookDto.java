package com.bookstore.book.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.time.LocalDate;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class BookDto {
    private String title;
    private String author;
    private String description;
    private BigDecimal price;
    private LocalDate publicationDate;
}
