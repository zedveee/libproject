package com.libray2.libproject.Exception;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.http.HttpStatus;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class ExceptionResponse {
    private String errorMessage;
    private String userErrorMessage;
    private int errorCode;
    private HttpStatus httpStatus;

}
