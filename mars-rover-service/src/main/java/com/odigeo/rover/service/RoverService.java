package com.odigeo.rover.service;

import com.odigeo.rover.contract.RoverMoveRequest;
import com.odigeo.rover.model.Plateau;
import com.odigeo.rover.model.Rover;

public interface RoverService {

    Rover placeRover(String roverId, Plateau plateau);

    Rover moveRover(RoverMoveRequest request);

}
