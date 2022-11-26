package com.libray2.libproject.dto;

import lombok.Data;
import org.springframework.stereotype.Component;

@Data
@Component
public class BookDto {
    private String name;
    private String language;
    private Integer noOfCopies;
    private String Tag;
    private String authorName;
}
