package com.libray2.libproject.dto;

import lombok.Data;
import org.springframework.stereotype.Component;

@Data
@Component
public class AuthorDto {
    private String name;
    private String Address;
}
