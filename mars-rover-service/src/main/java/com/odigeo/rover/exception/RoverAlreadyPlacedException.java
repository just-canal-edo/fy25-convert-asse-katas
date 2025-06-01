package com.odigeo.rover.exception;

import com.odigeo.rover.model.Rover;

public class RoverAlreadyPlacedException extends RoverException {

    public RoverAlreadyPlacedException(Rover rover) {
        super(String.format("Rover '%s' is already placed in position %s in plateau '%s'", rover.getRoverId(), rover.reportRoverStatus(), rover.getPlateau().getPlateauId()));
    }

}
