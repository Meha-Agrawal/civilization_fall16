package model;

import java.util.Random;

class QinDynasty extends Civilization{
    public QinDynasty() {
        super("Qin");
    }

    @Override
    public String explore() {
        if (!(getHills().replenishGame())) {
            int foodFound = getHills().hunt().getHealth();
            makeFood(foodFound);
            return "You found " + foodFound + " food.";
        } else {
            return "You ran out of food, but it has been replenished";
        }
    }

    @Override
    public SiegeUnit getSiegeUnit() {
        return new BlackPowderUnit(this);
    }

    @Override
    public Landmark getLandmark() {
        return new GreatWall(this);
    }
}
