package com.quiz.exceptions;

public class NotValidPayloadException extends RuntimeException{

    public NotValidPayloadException() {
        super();
    }


    public NotValidPayloadException(String message) {
        super(message);
    }


    public NotValidPayloadException(String message, Throwable cause) {
        super(message, cause);
    }


    public NotValidPayloadException(Throwable cause) {
        super(cause);
    }

}
