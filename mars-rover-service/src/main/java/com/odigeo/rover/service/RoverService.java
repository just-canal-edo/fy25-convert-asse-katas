package com.odigeo.rover.service;

import com.odigeo.rover.contract.RoverDeployRequest;
import com.odigeo.rover.contract.RoverMoveRequest;
import com.odigeo.rover.model.Plateau;
import com.odigeo.rover.model.Rover;

public interface RoverService {

    Rover placeRover(RoverDeployRequest roverDeployRequest, Plateau plateau);

    Rover moveRover(RoverMoveRequest request);

}
