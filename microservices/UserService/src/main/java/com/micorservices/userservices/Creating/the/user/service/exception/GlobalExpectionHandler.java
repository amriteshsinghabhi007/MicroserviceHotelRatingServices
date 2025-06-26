package com.micorservices.userservices.Creating.the.user.service.exception;

import com.micorservices.userservices.Creating.the.user.service.model.ApiResponse;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.HashMap;
import java.util.Map;

@RestControllerAdvice
public class GlobalExpectionHandler {

    @ExceptionHandler(ResourceNotFoundException.class)
    ResponseEntity<Map<String,Object>> HandleResourceNotFoundException(ResourceNotFoundException ex){
        Map map = new HashMap<>();
        map.put("Message",ex.getMessage());
        map.put("Success",false);
        map.put("Status",HttpStatus.NOT_FOUND);

        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(map);
    }
}
