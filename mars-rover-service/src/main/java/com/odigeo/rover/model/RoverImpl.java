package com.odigeo.rover.model;

public class RoverImpl implements Rover {

    protected final String roverId;
    protected final Plateau plateau;
    protected Coordinate position;
    protected Direction direction;

    public RoverImpl(String roverId, Plateau plateau) {
        this.roverId = roverId;
        this.plateau = plateau;
        placeRover(0, 0, Direction.NORTH); // Default position and direction
    }

    private void placeRover(int x, int y, Direction direction) throws IllegalArgumentException {
        if (!new Coordinate(x, y).coordinateIsOnPlateau(plateau.getPlateauXSize(), plateau.getPlateauYSize())) {
            throw new IllegalArgumentException("Position is out of bounds.");
        }

        this.position = new Coordinate(x, y);
        this.direction = direction;
        this.plateau.addRover(this);
    }

    /*
        Implement the logic to execute the command
        For example,
        if the command is "L", turn left
        if the command is "R", turn right
        If the command is "M", move forward
     */
    @Override
    public String move(String command) {
        // Check if command is valid
        if (!command.matches("[LRM]+")) {
            throw new IllegalArgumentException("Invalid command: " + command);
        }
        for (char c : command.toCharArray()) {
            processSimpleCommand(c);
        }

        return reportRoverStatus();
    }

    private void processSimpleCommand(char c) {
        switch (c) {
            case 'L':
                rotateDirectionLeft();
                break;
            case 'R':
                rotateDirectionRight();
                break;
            case 'M':
                moveForward();
                break;
            default:
                throw new IllegalArgumentException("Invalid command: " + c);
        }
    }

    private void moveForward() {
        final Coordinate newPosition = position.moveForward(direction, plateau);

        /*if (isOccupiedPosition(newPosition)) {
            throw new IllegalArgumentException("Position is already occupied by another rover.");
        } else {
            position = newPosition;
        }*/
        position = newPosition;
    }

    private boolean isOccupiedPosition(Coordinate newPosition) {
        return plateau.isPlateauOccupied(newPosition.getPositionX(), newPosition.getPositionY());
    }

    private void rotateDirectionLeft() {
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

    private void rotateDirectionRight() {
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
