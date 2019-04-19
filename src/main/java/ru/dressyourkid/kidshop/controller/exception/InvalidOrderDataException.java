package ru.dressyourkid.kidshop.controller.exception;

/**
 * When item was not found
 */
public class InvalidOrderDataException extends Exception {

    private String fieldName;

    public InvalidOrderDataException() {
        super();
    }

    public InvalidOrderDataException(String message) {
        super(message);
    }

    public InvalidOrderDataException(String fieldName, String message) {
        super(message);
        this.fieldName = fieldName;
    }

    public InvalidOrderDataException(String message, Throwable cause) {
        super(message, cause);
    }

    public InvalidOrderDataException(Throwable cause) {
        super(cause);
    }

    public String getFieldName() {
        return fieldName;
    }
}
