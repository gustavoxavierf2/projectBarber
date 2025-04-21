package project.barber.barberShop.config.exceptions.handler;

import org.springframework.http.HttpStatus;
import org.springframework.http.ProblemDetail;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import project.barber.barberShop.config.exceptions.GenericValidationException;

@RestControllerAdvice
public class Handler {
    @ExceptionHandler(GenericValidationException.class)
    public ProblemDetail handleGenericValidationException(GenericValidationException ex) {
        String message = ex.getMessage();

        ProblemDetail problemDetail = ProblemDetail.forStatusAndDetail(HttpStatus.valueOf(ex.getStatusCode()), message);
        problemDetail.setTitle("Validation Error");

        return problemDetail;

    }
    @ExceptionHandler(Exception.class)
    public ResponseEntity<String> handleAllExceptions(Exception ex) {
        return ResponseEntity
                .status(HttpStatus.INTERNAL_SERVER_ERROR)
                .body("Erro: " + ex.getMessage());
    }
}
