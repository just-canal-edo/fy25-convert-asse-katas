package com.odigeo.rover.repository;

import com.odigeo.rover.contract.RoverDeployRequest;
import com.odigeo.rover.contract.RoverMoveRequest;
import com.odigeo.rover.exception.RoverAlreadyPlacedException;
import com.odigeo.rover.exception.RoverNotFoundException;
import com.odigeo.rover.model.Plateau;
import com.odigeo.rover.model.Rover;
import com.odigeo.rover.model.RoverImpl;
import com.odigeo.rover.service.command.CommandProcessor;

import javax.inject.Inject;
import javax.inject.Singleton;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

@Singleton
public class RoverRepositoryImpl implements RoverRepository {

    @Inject
    private CommandProcessor commandProcessor;

    private Map<String, Rover> roverStore = new ConcurrentHashMap<>();

    @Override
    public Rover deployRover(RoverDeployRequest roverDeployRequest, Plateau plateau) {
        if (roverDeployRequest.getRoverId() == null) {
            throw new IllegalArgumentException(String.format("Invalid roverId: %s" ,roverDeployRequest.getRoverId()));
        }
        if (plateau == null) {
            throw new IllegalArgumentException(String.format("Invalid plateau: %s", plateau));
        }
        if (roverStore.containsKey(roverDeployRequest.getRoverId())) {
            throw new RoverAlreadyPlacedException(roverStore.get(roverDeployRequest.getRoverId()));
        } else {
            final Rover marsRover = new RoverImpl(roverDeployRequest.getRoverId(), roverDeployRequest.getPositionX(),
                    roverDeployRequest.getPositionY(), roverDeployRequest.getDirection(), plateau);
            roverStore.put(marsRover.getRoverId(), marsRover);

            return marsRover;
        }
    }

    @Override
    public Rover moveRover(RoverMoveRequest request) {
        if (request.getRoverId() == null) {
            throw new IllegalArgumentException(String.format("Invalid roverId: %s", request.getRoverId()));
        }
        if (roverStore.containsKey(request.getRoverId())) {
            Rover rover = roverStore.get(request.getRoverId());
            commandProcessor.processCommand(request.getCommand(), rover);
            return rover;
        } else {
            throw new RoverNotFoundException(request.getRoverId());
        }
    }

    @Override
    public List<Rover> getAllRovers() {
        return new ArrayList<>(roverStore.values());
    }
}
