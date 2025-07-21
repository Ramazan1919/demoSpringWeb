package com.sarisoku.sumus.dto;


import lombok.*;

@Getter
@Setter
@Builder
public class AuthorDto {



    private String name;

    private String nationality;

    public AuthorDto() {

    }
}
