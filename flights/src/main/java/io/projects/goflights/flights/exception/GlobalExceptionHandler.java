package io.projects.goflights.flights.exception;

import io.projects.goflights.flights.dto.ErrorResponseDTO;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;

import java.time.LocalDateTime;

@ControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(RecordNotFoundException.class)
    public ResponseEntity<ErrorResponseDTO> handleRecordNotFoundException(RecordNotFoundException recordNotFoundException, WebRequest webRequest){
        ErrorResponseDTO errorResponseDTO = new ErrorResponseDTO(webRequest.getDescription(true),recordNotFoundException.getMessage(), LocalDateTime.now());
        return  new ResponseEntity<>(errorResponseDTO, HttpStatus.INTERNAL_SERVER_ERROR);
    }
}
