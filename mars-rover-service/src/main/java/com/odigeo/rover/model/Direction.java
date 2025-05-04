package com.odigeo.rover.model;

public enum Direction {
    NORTH("N"),
    EAST("E"),
    SOUTH("S"),
    WEST("W");

    private final String value;

    Direction(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }

    public static Direction fromValue(String value) {
        for (Direction direction : values()) {
            if (direction.getValue().equals(value)) {
                return direction;
            }
        }
        throw new IllegalArgumentException("Invalid direction: " + value);
    }
}
