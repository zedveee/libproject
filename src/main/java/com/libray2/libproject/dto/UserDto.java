package com.libray2.libproject.dto;

import lombok.Data;
import org.springframework.stereotype.Component;

@Component
@Data
public class UserDto {
    private String name;
    private String phone;
    private String address;
}
