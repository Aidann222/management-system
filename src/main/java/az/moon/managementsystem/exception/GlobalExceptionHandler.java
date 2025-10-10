package az.moon.managementsystem.exception;

import az.moon.managementsystem.exception.errors.ErrorResponse;
import az.moon.managementsystem.exception.exits.AlreadyExistsException;
import az.moon.managementsystem.exception.notfound.UserNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(UserNotFoundException.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    public ErrorResponse handlerUserNotFoundException(UserNotFoundException exception) {
        return ErrorResponse.builder()
                .code(HttpStatus.NOT_FOUND.value())
                .message(exception.getMessage())
                .build();
    }
    @ExceptionHandler(AlreadyExistsException.class)
    @ResponseStatus(HttpStatus.CONFLICT)
    public ErrorResponse handlerAlreadyExistsException(AlreadyExistsException exception) {
        return ErrorResponse.builder()
                .code(HttpStatus.CONFLICT.value())
                .message(exception.getMessage())
                .build();

    }

    @ExceptionHandler(MethodArgumentNotValidException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public ErrorResponse handlerValidException(MethodArgumentNotValidException exception) {

        String fieldName = exception.getBindingResult().getFieldError().getField();

        String message = exception.getBindingResult().getFieldError().getDefaultMessage();

        return ErrorResponse.builder()
                .code(HttpStatus.BAD_REQUEST.value())
                .message(fieldName + message)
                .build();
    }

}