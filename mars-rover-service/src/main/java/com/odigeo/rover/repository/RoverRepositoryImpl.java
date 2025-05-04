package com.odigeo.rover.repository;

import com.odigeo.rover.contract.RoverMoveRequest;
import com.odigeo.rover.exception.RoverAlreadyPlacedException;
import com.odigeo.rover.exception.RoverNotFoundException;
import com.odigeo.rover.model.Plateau;
import com.odigeo.rover.model.Rover;
import com.odigeo.rover.model.RoverImpl;

import javax.ejb.Singleton;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

@Singleton
public class RoverRepositoryImpl implements RoverRepository {

    private Map<String, Rover> roverStore = new ConcurrentHashMap<>();

    @Override
    public Rover placeRover(String roverId, Plateau plateau) {
        if (roverId == null) {
            throw new IllegalArgumentException("Invalid roverId: " + roverId);
        }
        if (plateau == null) {
            throw new IllegalArgumentException("Invalid plateau: " + plateau);
        }
        if (roverStore.containsKey(roverId)) {
            throw new RoverAlreadyPlacedException(roverId);
        } else {
            final Rover marsRover = new RoverImpl(roverId, plateau);
            roverStore.put(marsRover.getRoverId(), marsRover);

            return marsRover;
        }
    }

    @Override
    public Rover moveRover(RoverMoveRequest request) {
        if (request.getRoverId() == null) {
            throw new IllegalArgumentException("Invalid roverId: " + request);
        }
        if (roverStore.containsKey(request.getRoverId())) {
            Rover rover = roverStore.get(request.getRoverId());
            rover.move(request.getCommand());
            return rover;
        } else {
            throw new RoverNotFoundException(request.getRoverId());
        }
    }

    @Override
    public List<Rover> getAllRovers() {
        // Implementation to get all rovers
        return new ArrayList<>(roverStore.values());
    }
}
