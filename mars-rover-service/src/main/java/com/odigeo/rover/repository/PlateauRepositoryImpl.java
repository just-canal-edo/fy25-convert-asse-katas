package com.odigeo.rover.repository;

import com.odigeo.rover.model.Plateau;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class PlateauRepositoryImpl implements PlateauRepository {

    private Map<String, Plateau> plateauStore = new ConcurrentHashMap<>();

    @Override
    public Plateau createOrRetrivePlateau(String plateauId, int plateauXSize, int plateauYSize) {
        if (plateauId == null) {
            throw new IllegalArgumentException("Invalid plateauId: " + plateauId);
        }
        if (plateauXSize <= 0 || plateauYSize <= 0) {
            throw new IllegalArgumentException("Invalid plateau dimensions: " + plateauXSize + "x" + plateauYSize);
        }
        if (plateauStore.containsKey(plateauId)) {
            return plateauStore.get(plateauId);
        } else {
            final Plateau plateau = new Plateau(plateauId, plateauXSize, plateauYSize);
            plateauStore.put(plateau.getPlateauId(), plateau);
            return plateau;
        }
    }

    @Override
    public List<Plateau> getAllPlateaus() {
        // Implementation to get all plateaus
        return new ArrayList<>(plateauStore.values());
    }
}
