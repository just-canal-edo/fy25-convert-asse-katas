package com.odigeo.rover.model;

public interface Rover {

    void rotateDirectionRight();

    void rotateDirectionLeft();

    void moveForward();

    String reportRoverStatus();

    String getRoverId();

    Coordinate getPosition();

    Plateau getPlateau();
}
