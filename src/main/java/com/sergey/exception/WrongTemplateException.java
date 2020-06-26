package com.sergey.exception;

public class WrongTemplateException extends RuntimeException {
    public WrongTemplateException() {
    }

    public WrongTemplateException(String message) {
        super("Wrong data template in the file - " + message);
    }
}
