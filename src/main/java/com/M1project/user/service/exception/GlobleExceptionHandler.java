package com.M1project.user.service.exception;

import com.M1project.user.service.payloadResponce.ExceptionResponce;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;

import java.time.LocalDateTime;

public class GlobleExceptionHandler {
    @ExceptionHandler(Exception.class)
    public ResponseEntity<ExceptionResponce> ExceptionHandler(Exception ex,
                                                              WebRequest req) {
        ExceptionResponce response = new ExceptionResponce(
                ex.getMessage(),
                req.getDescription(false),
                LocalDateTime.now()
        );
        return ResponseEntity
                .ok(response);
    }
}
