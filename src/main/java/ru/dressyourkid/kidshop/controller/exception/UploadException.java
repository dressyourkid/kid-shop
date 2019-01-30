package ru.dressyourkid.kidshop.controller.exception;

/**
 * When fails to upload a resource
 */
public class UploadException extends Exception {
    public UploadException() {
        super();
    }

    public UploadException(String message) {
        super(message);
    }

    public UploadException(String message, Throwable cause) {
        super(message, cause);
    }

    public UploadException(Throwable cause) {
        super(cause);
    }
}
