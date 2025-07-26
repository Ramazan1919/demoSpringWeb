package com.sarisoku.sumus.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Getter;
import lombok.Setter;

import java.sql.Timestamp;

@Getter
@Setter
public class BookDto {
    @Schema(description = "Kitap adı", example = "1984")
    private String name;

    @Schema(description = "Kitap ISBN kodu", example = "978-0451524935")
    private String isbn;

    @Schema(description = "Kitabın yayımlanma tarihi", type = "string", format = "date-time", example = "2025-07-26T17:09:40.829Z")
    private Timestamp date;

    private Long authorId;


}
