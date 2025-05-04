package com.odigeo.rover.controller;

import com.odigeo.rover.contract.RoverMoveResponse;
import com.odigeo.rover.contract.RoverMoveRequest;
import com.odigeo.rover.contract.RoverPlaceRequest;
import com.odigeo.rover.contract.RoverPlaceResponse;

public interface RoverRestUI {

    RoverPlaceResponse placeRover(RoverPlaceRequest roverPlaceRequest);

    RoverMoveResponse moveRover(RoverMoveRequest roverMoveRequest);

}
