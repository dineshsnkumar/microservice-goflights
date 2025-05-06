package io.projects.goflights.customers.exceptions;

import io.projects.goflights.customers.dto.ErrorResponseDTO;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.ErrorResponse;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;

import java.time.LocalDateTime;

@ControllerAdvice
public class GlobalCustomerException {

    @ExceptionHandler(Exception.class)
    public ResponseEntity<ErrorResponseDTO> handleGlobalException(Exception existsException, WebRequest request){
        ErrorResponseDTO errorResponse = new ErrorResponseDTO(request.getDescription(true), HttpStatus.INTERNAL_SERVER_ERROR, existsException.getMessage(), LocalDateTime.now());
        return new ResponseEntity<>(errorResponse, HttpStatus.INTERNAL_SERVER_ERROR);
    }


    @ExceptionHandler(CustomerAlreadyExistsException.class)
    public ResponseEntity<ErrorResponseDTO> handleCustomerAlreadyExistsException(CustomerAlreadyExistsException existsException, WebRequest request){
        ErrorResponseDTO errorResponse = new ErrorResponseDTO(request.getDescription(true), HttpStatus.BAD_REQUEST, existsException.getMessage(), LocalDateTime.now());
        return new ResponseEntity<>(errorResponse, HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(ResourceNotFoundException.class)
    public ResponseEntity<ErrorResponseDTO> handleCustomerAlreadyExistsException(ResourceNotFoundException existsException, WebRequest request){
        ErrorResponseDTO errorResponse = new ErrorResponseDTO(request.getDescription(true), HttpStatus.BAD_REQUEST, existsException.getMessage(), LocalDateTime.now());
        return new ResponseEntity<>(errorResponse, HttpStatus.NOT_FOUND);
    }


}
