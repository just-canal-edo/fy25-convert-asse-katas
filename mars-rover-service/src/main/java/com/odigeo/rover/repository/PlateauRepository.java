package com.odigeo.rover.repository;

import com.odigeo.rover.model.Plateau;

import java.util.List;

public interface PlateauRepository {

    Plateau createOrRetrivePlateau(String plateauId, int plateauXSize, int plateauYSize);

    public List<Plateau> getAllPlateaus();
}
