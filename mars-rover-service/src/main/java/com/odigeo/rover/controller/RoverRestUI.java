package com.odigeo.rover.controller;

import com.odigeo.rover.contract.RoverMoveResponse;
import com.odigeo.rover.contract.RoverMoveRequest;
import com.odigeo.rover.contract.RoverDeployRequest;
import com.odigeo.rover.contract.RoverDeployResponse;

public interface RoverRestUI {

    RoverDeployResponse deployRover(RoverDeployRequest roverDeployRequest);

    RoverMoveResponse moveRover(RoverMoveRequest roverMoveRequest);

}
