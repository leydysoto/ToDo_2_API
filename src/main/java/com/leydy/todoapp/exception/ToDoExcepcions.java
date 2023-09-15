package com.leydy.todoapp.exception;

import lombok.Data;
import org.springframework.http.HttpStatus;
@Data
public class ToDoExcepcions  extends RuntimeException{
    private String message;
    private HttpStatus httpStatus;

    public ToDoExcepcions (String message,HttpStatus httpStatus){
        super(message);
        this.message=message;
        this.httpStatus=httpStatus;
    }
}







