package com.example.mvc.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Component;

@Data
@NoArgsConstructor
public class Book {
    private Integer id;
    private String name;
    private String type;
    private String description;

}
