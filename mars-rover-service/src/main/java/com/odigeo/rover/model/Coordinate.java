package com.odigeo.rover.model;

public class Coordinate {
    private int positionX;
    private int positionY;

    public Coordinate(int x, int y) {
        this.positionX = x;
        this.positionY = y;
    }

    public boolean coordinateIsOnPlateau(int plateauXSize, int plateauYSize) {
        return positionX >= 0 && positionX < plateauXSize && positionY >= 0 && positionY < plateauYSize;
    }

    public Coordinate moveForward(Direction direction, Plateau plateau) throws IllegalArgumentException {
        switch (direction) {
            case NORTH:
                return new Coordinate(positionX, (positionY + 1) % plateau.getPlateauYSize());
            case SOUTH:
                return new Coordinate(positionX, (positionY - 1 + plateau.getPlateauYSize()) % plateau.getPlateauYSize());
            case EAST:
                return new Coordinate((positionX + 1) % plateau.getPlateauXSize(), positionY);
            case WEST:
                return new Coordinate((positionX - 1 + plateau.getPlateauXSize()) % plateau.getPlateauXSize(), positionY);
            default:
                throw new IllegalArgumentException("Invalid direction: " + direction);
        }
    }

    public int getPositionX() {
        return positionX;
    }

    public void setPositionX(int positionX) {
        this.positionX = positionX;
    }

    public int getPositionY() {
        return positionY;
    }

    public void setPositionY(int positionY) {
        this.positionY = positionY;
    }

}
