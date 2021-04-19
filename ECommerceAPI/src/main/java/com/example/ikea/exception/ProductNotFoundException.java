package com.example.ikea.exception;

import lombok.NoArgsConstructor;
import org.springframework.http.HttpStatus;

@NoArgsConstructor
public class ProductNotFoundException extends RuntimeException {

    private static String errorMsg = "Product Not Found";
    private static HttpStatus status = HttpStatus.NOT_FOUND;

    public String getErrorMsg() {
        return errorMsg;
    }

    public HttpStatus getStatus() {
        return status;
    }
}
