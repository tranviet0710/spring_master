package org.customer;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@ControllerAdvice
public class CustomerNotFoundAdvice {
    @ResponseBody
    @ExceptionHandler(CustomerNotFoundException.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    public String customerNotFoundHandler(CustomerNotFoundException exception){
        return exception.getMessage();
    }
}

