package com.educandoweb.course.entities.dto;

import jakarta.persistence.EntityNotFoundException;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class RequestsExceptionsHandler {
    @ExceptionHandler(EntityNotFoundException.class)
    public ResponseEntity threat404(){
        ExceptionsDTO response = new ExceptionsDTO("Dado não encontrado");
        return ResponseEntity.badRequest().body(response);
    }
}
