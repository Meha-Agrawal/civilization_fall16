package model;

import java.util.Random;

class Egypt extends Civilization{
    private Desert desert = new Desert();

    public Egypt() {
        super("Egypt");
    }

    @Override
    public String explore() {
        int treasureFound = desert.findTreasure();
        getTreasury().earn(treasureFound);
        return ("You found " + treasureFound + " treasure.");
    }

    @Override
    public RangedUnit getRangedUnit() {
        return new WarChariot(this);
    }

    @Override
    public Landmark getLandmark() {
        return new Pyramid(this);
    }
}
