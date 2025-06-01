package com.odigeo.rover.contract;

public class RoverMoveRequest {

    private String roverId;

    private String command;

    private String plateauId;

    public String getCommand() {
        return command;
    }

    public void setCommand(String command) {
        this.command = command;
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
}
