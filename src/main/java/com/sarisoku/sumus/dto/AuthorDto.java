package com.sarisoku.sumus.dto;


import io.swagger.v3.oas.annotations.media.Schema;
import lombok.*;

import java.util.List;

@Getter
@Setter
public class AuthorDto {

    @Schema(description = "Yazarın adı", example = "George Orwell")
    private String name;

    @Schema(description = "Yazarın milliyeti", example = "British")
    private String nationality;

    @Schema(description = "Yazarın yaşı", example = "46")
    private int age;

    @Schema(description = "Yazarın kitap listesi")
    private List<BookDto> books;
}
