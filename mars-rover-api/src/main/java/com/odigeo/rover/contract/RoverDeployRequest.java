package com.odigeo.rover.contract;

public class RoverDeployRequest {

    private String roverId;
    private int positionX;
    private int positionY;
    private String direction;
    private String plateauId;
    private int plateauXSize;
    private int plateauYSize;

    public String getRoverId() {
        return roverId;
    }

    public void setRoverId(String roverId) {
        this.roverId = roverId;
    }

    public String getPlateauId() {
        return plateauId;
    }

    public void setPlateauId(String plateauId) {
        this.plateauId = plateauId;
    }

    public int getPlateauXSize() {
        return plateauXSize;
    }

    public void setPlateauXSize(int plateauXSize) {
        this.plateauXSize = plateauXSize;
    }

    public int getPlateauYSize() {
        return plateauYSize;
    }

    public void setPlateauYSize(int plateauYSize) {
        this.plateauYSize = plateauYSize;
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
    public String getDirection() {
        return direction;
    }
    public void setDirection(String direction) {
        this.direction = direction;
    }
}
