package com.odigeo.rover.exception;

public class RoverNotFoundException extends RoverException {

    public RoverNotFoundException(String gameId) {
        super(String.format("Rover %s not found", gameId));
    }

}
