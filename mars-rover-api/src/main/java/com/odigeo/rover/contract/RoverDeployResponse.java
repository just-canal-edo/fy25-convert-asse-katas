package com.odigeo.rover.contract;

public class RoverDeployResponse {

    private String roverId;
    private String plateauId;
    private String startingPoint;

    public RoverDeployResponse(String roverId, String plateauId, String startingPoint) {
        this.roverId = roverId;
        this.plateauId = plateauId;
        this.startingPoint = startingPoint;
    }

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

    public String getStartingPoint() {
        return startingPoint;
    }

    public void setStartingPoint(String startingPoint) {
        this.startingPoint = startingPoint;
    }
}
