package br.com.safeline.modules.exception;


import org.springframework.http.ResponseEntity;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import br.com.safeline.modules.report.exception.ReportNotFoundException;
import br.com.safeline.modules.response.BaseResponse;
import br.com.safeline.modules.user.exception.EmailAlreadyExistsException;
import jakarta.validation.ConstraintViolation;
import jakarta.validation.ConstraintViolationException;

@RestControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(ConstraintViolationException.class)
    public ResponseEntity<BaseResponse<String>> handleException(ConstraintViolationException ex) {

        String message = ex.getConstraintViolations()
                .stream()
                .findFirst()
                .map(ConstraintViolation::getMessage)
                .orElse("Erro de validação");

        BaseResponse<String> response = BaseResponse.error(message);
        response.setStatusCode(400);

        return ResponseEntity.status(400).body(response);
    }

    @ExceptionHandler({EmailAlreadyExistsException.class})
    public ResponseEntity<BaseResponse<String>> handleAlreadyExistException(RuntimeException ex) {

        BaseResponse<String> response = BaseResponse.error(ex.getMessage());
        response.setStatusCode(409);

        return ResponseEntity.status(409).body(response);
    }

    @ExceptionHandler({UsernameNotFoundException.class, ReportNotFoundException.class})
    public ResponseEntity<BaseResponse<String>> handleUsernameNotFoundException(RuntimeException ex) {

        BaseResponse<String> response = BaseResponse.error(ex.getMessage());
        response.setStatusCode(404);

        return ResponseEntity.status(404).body(response);
    }
}
