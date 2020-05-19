package com.bridgelabz.exception;

public class MyStackException extends Exception {
    public enum ExceptionType {STACK_OVER_FLOW, STACK_UNDER_FLOW}

    ExceptionType type;

    public MyStackException(ExceptionType type, String message) {
        super(message);
        this.type = type;
    }
}
