package com.libray2.libproject.dto;

import lombok.Data;

import java.util.List;


@Data
public class IssueDto {
    private Long userId;
    private List<Long>  bookId;
}
