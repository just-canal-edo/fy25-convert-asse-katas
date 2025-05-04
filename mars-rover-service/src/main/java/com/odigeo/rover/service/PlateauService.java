package com.odigeo.rover.service;

import com.odigeo.rover.model.Plateau;

public interface PlateauService {

    Plateau createOrRetrivePlateau(String plateauName, int plateauXSize, int plateauYSize);
}
