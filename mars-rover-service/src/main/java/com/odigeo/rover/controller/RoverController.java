package com.odigeo.rover.controller;

import com.odigeo.rover.contract.RoverMoveResponse;
import com.odigeo.rover.contract.RoverMoveRequest;
import com.odigeo.rover.contract.RoverDeployRequest;
import com.odigeo.rover.contract.RoverDeployResponse;
import com.odigeo.rover.model.Plateau;
import com.odigeo.rover.model.Rover;
import com.odigeo.rover.service.PlateauService;
import com.odigeo.rover.service.RoverService;

import javax.inject.Inject;
import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;


@Path("/rover")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class RoverController implements RoverRestUI {

    @Inject
    private RoverService roverService;
    @Inject
    private PlateauService plateauService;

    public RoverController() { }

    @Override
    @POST
    @Path("/deployRover")
    public RoverDeployResponse deployRover(RoverDeployRequest roverDeployRequest) {
        final Plateau plateau = plateauService.createOrRetrivePlateau(roverDeployRequest.getPlateauId(), roverDeployRequest.getPlateauXSize(), roverDeployRequest.getPlateauYSize());

        final Rover rover = roverService.placeRover(roverDeployRequest, plateau);

        return new RoverDeployResponse(rover.getRoverId(), rover.getPlateau().getPlateauId(), rover.reportRoverStatus());
    }

    @Override
    @POST
    @Path("/moveRover")
    public RoverMoveResponse moveRover(RoverMoveRequest roverMoveRequest) {
        return new RoverMoveResponse(roverService.moveRover(roverMoveRequest).reportRoverStatus());
    }

}
