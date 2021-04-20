package com.example.ikea.exception;

import com.example.ikea.response.ApiResponse;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

@ControllerAdvice
public class IkeaExceptionHandler {

    @ResponseStatus(HttpStatus.NOT_FOUND)
    @ExceptionHandler({ProductNotFoundException.class})
    public ResponseEntity<ApiResponse> handlerProductNotFoundExcpetion(ProductNotFoundException re) {
        return new ResponseEntity<ApiResponse>(new ApiResponse(re.getErrorMsg()), re.getStatus());
    }

    @ResponseStatus(HttpStatus.NOT_FOUND)
    @ExceptionHandler({InventoryNotFoundException.class})
    public ResponseEntity<ApiResponse> handlerInventoryNotFoundExcpetion(InventoryNotFoundException re) {
        return new ResponseEntity<ApiResponse>(new ApiResponse(re.getErrorMsg()), re.getStatus());
    }
}
