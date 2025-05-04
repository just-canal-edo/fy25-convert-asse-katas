package com.odigeo.rover.contract;

public class PlateauRequest {

    private String plateauName;
    private int plateauXSize;
    private int plateauYSize;

    public String getPlateauName() {
        return plateauName;
    }

    public void setPlateauName(String plateauName) {
        this.plateauName = plateauName;
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
