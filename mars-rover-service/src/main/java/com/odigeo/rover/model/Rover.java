package com.odigeo.rover.model;

public interface Rover {

    String move(String command);

    public String reportRoverStatus();

    String getRoverId();

    Coordinate getPosition();

    Plateau getPlateau();
}
