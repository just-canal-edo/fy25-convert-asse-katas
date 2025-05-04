package com.odigeo.rover.contract;

public class RoverPlaceRequest {

    private String roverId;
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
}
