package com.odigeo.rover.model;

public class RoverImpl implements Rover {

    protected final String roverId;
    protected final Plateau plateau;
    protected Coordinate position;
    protected Direction direction;

    public RoverImpl(String roverId, int positionX, int positionY, String direction, Plateau plateau) throws IllegalArgumentException {
        this.roverId = roverId;
        this.plateau = plateau;
        placeRover(positionX, positionY, Direction.fromValue(direction)); // Default position and direction
    }

    private void placeRover(int positionX, int positionY, Direction direction) throws IllegalArgumentException {
        if (!new Coordinate(positionX, positionY).coordinateIsOnPlateau(plateau.getPlateauXSize(), plateau.getPlateauYSize())) {
            throw new IllegalArgumentException("Position is out of bounds.");
        } else {
            final Rover occupiedRoverPosition = isOccupiedPosition(new Coordinate(positionX, positionY));
            if (occupiedRoverPosition != null) {
                throw new IllegalArgumentException(String.format("Position '%s' is already occupied by another rover: %s", occupiedRoverPosition.reportRoverStatus(),occupiedRoverPosition.getRoverId()));
            }
        }

        this.position = new Coordinate(positionX, positionY);
        this.direction = direction;
        this.plateau.addRover(this);
    }

    @Override
    public void moveForward() {
        final Coordinate newPosition = position.moveForward(direction, plateau);

        final Rover occupiedRoverPosition = isOccupiedPosition(newPosition);
        if (occupiedRoverPosition != null) {
            throw new IllegalArgumentException(String.format("Position '%s' is already occupied by another rover: %s", occupiedRoverPosition.reportRoverStatus(),occupiedRoverPosition.getRoverId()));
        } else {
            position = newPosition;
        }
    }

    @Override
    public void rotateDirectionLeft() {
        switch (direction) {
            case NORTH:
                direction = Direction.WEST;
                break;
            case WEST:
                direction = Direction.SOUTH;
                break;
            case SOUTH:
                direction = Direction.EAST;
                break;
            case EAST:
                direction = Direction.NORTH;
                break;
        }
    }

    @Override
    public void rotateDirectionRight() {
        switch (direction) {
            case NORTH:
                direction = Direction.EAST;
                break;
            case EAST:
                direction = Direction.SOUTH;
                break;
            case SOUTH:
                direction = Direction.WEST;
                break;
            case WEST:
                direction = Direction.NORTH;
                break;
        }
    }

    private Rover isOccupiedPosition(Coordinate newPosition) {
        return plateau.isPlateauOccupied(newPosition.getPositionX(), newPosition.getPositionY());
    }

    @Override
    public String reportRoverStatus() {
        return position.getPositionX() + ":" + position.getPositionY() + ":" + direction.getValue();
    }

    @Override
    public String getRoverId() {
        return roverId;
    }

    @Override
    public Plateau getPlateau() {
        return plateau;
    }

    @Override
    public Coordinate getPosition() {
        return position;
    }

    public void setPosition(Coordinate position) {
        this.position = position;
    }

    public Direction getDirection() {
        return direction;
    }

    public void setDirection(Direction direction) {
        this.direction = direction;
    }
}
