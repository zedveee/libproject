package com.libray2.libproject.Exception;

import com.libray2.libproject.external.ErrorCodes;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.http.HttpStatus;


@Builder
@AllArgsConstructor
@NoArgsConstructor
@Data
public class LibraryException  extends Exception{
    private String ErrorMessage;
    private String UserErrorMessage;
    private int errorCode;
    private HttpStatus httpStatus;

    public static LibraryException libraryExceptionImpl(ErrorCodes errorCodes){
            return LibraryException.builder().ErrorMessage(errorCodes.getErrorMessage()).UserErrorMessage(errorCodes.getUserErrorMessage()).errorCode(errorCodes.getErrorCode()).httpStatus(HttpStatus.INTERNAL_SERVER_ERROR).build();
    }
}
