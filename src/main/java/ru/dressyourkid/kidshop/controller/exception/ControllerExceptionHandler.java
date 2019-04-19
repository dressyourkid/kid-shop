package ru.dressyourkid.kidshop.controller.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import ru.dressyourkid.kidshop.model.exception.ErrorMessage;

/**
 * Created by lconnected on 18/01/2018.
 */
@SuppressWarnings("unused")
@ControllerAdvice
public class ControllerExceptionHandler {

    @ExceptionHandler({ NotFoundException.class })
    @ResponseStatus(HttpStatus.NOT_FOUND)
    public Object notFoundHandler(Exception exception) {
        return new ErrorMessage(HttpStatus.NOT_FOUND.value(), exception.getMessage());
    }

    @ExceptionHandler({ InvalidOrderDataException.class })
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public Object badRequestHandler(InvalidOrderDataException exception) {
        // todo custom error message
        return new ErrorMessage(0, "pipka");
    }

    @ExceptionHandler(Exception.class)
    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    public Object internalErrorsHandler(Exception exception) {
        return new ErrorMessage(HttpStatus.INTERNAL_SERVER_ERROR.value(), exception.getMessage());
    }

}
