package com.bookstore.book;

import jakarta.persistence.*;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.*;
import org.springframework.format.annotation.DateTimeFormat;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.UUID;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
@Table(name = "books")
public class Book {
    @Id
    @GeneratedValue
    @Column(name = "bookId", updatable = false)
    private UUID id;

    @NotBlank(message = "Title is required.")
    private String title;

    @NotBlank(message = "Author is required.")
    private String author;

    private String description;

    @NotNull(message = "Price is required.")
    @Min(value = 0, message = "Price must be greater than or equal to zero.")
    private BigDecimal price;

    @NotNull(message = "Publication date is required.")
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private LocalDate publicationDate;
}
