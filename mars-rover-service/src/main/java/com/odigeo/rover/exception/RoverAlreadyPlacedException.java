package com.odigeo.rover.exception;

public class RoverAlreadyPlacedException extends RoverException {

    public RoverAlreadyPlacedException(String roverId) {
        super(String.format("Rover %s is already placed", roverId));
    }

}
