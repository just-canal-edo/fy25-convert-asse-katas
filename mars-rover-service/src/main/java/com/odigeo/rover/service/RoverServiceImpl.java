package com.odigeo.rover.service;

import com.odigeo.rover.contract.RoverDeployRequest;
import com.odigeo.rover.contract.RoverMoveRequest;
import com.odigeo.rover.model.Plateau;
import com.odigeo.rover.model.Rover;
import com.odigeo.rover.repository.RoverRepository;

import javax.inject.Inject;
import javax.inject.Singleton;

@Singleton
public class RoverServiceImpl implements RoverService {

    @Inject
    private RoverRepository roverRepository;

    @Override
    public Rover deployRover(RoverDeployRequest roverDeployRequest, Plateau plateau) {
        return roverRepository.deployRover(roverDeployRequest, plateau);
    }

    @Override
    public Rover moveRover(RoverMoveRequest request) {
        return roverRepository.moveRover(request);
    }
}
