package model;

import java.util.Random;

class RomanEmpire extends Civilization{

    public RomanEmpire() {
        super("Roman");
    }

    @Override
    public String explore() {
        int resourcesFound = getHills().mineCoal();
        produceResources(resourcesFound);
        return "You found " + resourcesFound + " resources.";
    }

    @Override
    public MeleeUnit getMeleeUnit() {
        return new LegionUnit(this);
    }

    @Override
    public Landmark getLandmark() {
        return new Coliseum(this);
    }
}
