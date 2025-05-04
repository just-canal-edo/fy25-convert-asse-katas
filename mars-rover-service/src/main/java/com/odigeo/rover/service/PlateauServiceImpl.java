package com.odigeo.rover.service;

import com.odigeo.rover.model.Plateau;
import com.odigeo.rover.repository.PlateauRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.inject.Inject;
import javax.inject.Singleton;

@Singleton
public class PlateauServiceImpl implements PlateauService {

    @Inject
    private PlateauRepository plateauRepository;

    public Plateau createOrRetrivePlateau(String plateauName, int plateauXSize, int plateauYSize) {
        return plateauRepository.createOrRetrivePlateau(plateauName, plateauXSize, plateauYSize);
    }


}
