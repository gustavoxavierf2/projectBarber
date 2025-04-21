package project.barber.barberShop.config.exceptions;

import lombok.Getter;
import org.springframework.http.HttpStatus;

@Getter
public class GenericValidationException extends Exception {

    private final Integer statusCode;

    public GenericValidationException(String message, HttpStatus statusCode) {
        super(message);
        this.statusCode = statusCode.value();
    }
}