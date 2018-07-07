package com.quiz.exceptions;

public class NotValidAnswerException extends RuntimeException{

    public NotValidAnswerException() {
        super();
    }


    public NotValidAnswerException(String message) {
        super(message);
    }


    public NotValidAnswerException(String message, Throwable cause) {
        super(message, cause);
    }


    public NotValidAnswerException(Throwable cause) {
        super(cause);
    }

}
