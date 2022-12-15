package com.sam.digicertbooksdemo.models;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@AllArgsConstructor
public class Book {
    @Getter @Setter
    private Integer id;

    @Getter @Setter
    private String title;

    @Getter @Setter
    private String author;
}
