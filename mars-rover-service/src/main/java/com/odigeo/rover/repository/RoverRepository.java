package com.odigeo.rover.repository;

import com.odigeo.rover.contract.RoverDeployRequest;
import com.odigeo.rover.contract.RoverMoveRequest;
import com.odigeo.rover.model.Plateau;
import com.odigeo.rover.model.Rover;

import java.util.List;

public interface RoverRepository {

    Rover placeRover(RoverDeployRequest roverDeployRequest, Plateau plateau);

    Rover moveRover(RoverMoveRequest request);

    List<Rover> getAllRovers();
}
