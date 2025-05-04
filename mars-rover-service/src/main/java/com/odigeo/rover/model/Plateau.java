package com.odigeo.rover.model;

import java.util.ArrayList;
import java.util.List;

public class Plateau {

    private final String plateauId;
    private final int plateauXSize;
    private final int plateauYSize;
    // private Coordinate[][] grid;
    private List<Rover> marsRovers;

    public Plateau(String plateauId, int plateauXSize, int plateauYSize) {
        this.plateauId = plateauId;
        this.plateauXSize = plateauXSize;
        this.plateauYSize = plateauYSize;
        // initialize roverPositions with the size of the plateau
        //this.grid = new Coordinate[plateauXSize][plateauYSize];
        this.marsRovers = new ArrayList<>();
    }

    public boolean isPlateauOccupied(int x, int y) {
        for (Rover rover : marsRovers) {
            if (rover.getPosition().getPositionX() == x && rover.getPosition().getPositionY() == y) {
                return true;
            }
        }
        return false;
    }
    public void addRover(Rover rover) {
        /*if (!isPlateauOccupied(rover.getPosition().getPositionX(), rover.getPosition().getPositionY())) {
            marsRovers.add(rover);
        } else {
            throw new IllegalArgumentException("Position is already occupied by another rover.");
        }*/
        marsRovers.add(rover);
    }

    public String getPlateauId() {
        return plateauId;
    }
    public int getPlateauXSize() {
        return plateauXSize;
    }
    public int getPlateauYSize() {
        return plateauYSize;
    }
    /*public Coordinate[][] getGrid() {
        return grid;
    }
    public void setGrid(Coordinate[][] grid) {
        this.grid = grid;
    }*/
    public List<Rover> getRovers() {
        return marsRovers;
    }
    public void setRovers(List<Rover> marsRovers) {
        this.marsRovers = marsRovers;
    }
}
