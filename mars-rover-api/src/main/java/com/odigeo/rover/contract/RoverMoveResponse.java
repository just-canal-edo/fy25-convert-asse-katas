package com.odigeo.rover.contract;

public class RoverMoveResponse {

    private String finishingPoint;

    public RoverMoveResponse() {
    }

    public RoverMoveResponse(String finishingPoint) {
        this.finishingPoint = finishingPoint;
    }
    public String getFinishingPoint() {
        return finishingPoint;
    }
    public void setFinishingPoint(String finishingPoint) {
        this.finishingPoint = finishingPoint;
    }
}
