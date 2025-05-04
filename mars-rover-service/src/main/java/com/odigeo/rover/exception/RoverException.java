package com.odigeo.rover.exception;

public class RoverException extends RuntimeException {

    public RoverException(String s) {
        super(s);
    }

    public RoverException(String s, Throwable throwable) {
        super(s, throwable);
    }

}
