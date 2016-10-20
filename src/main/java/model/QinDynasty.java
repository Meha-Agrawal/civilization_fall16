package model;



class QinDynasty extends Civilization {
    private Hills hills = new Hills();

    public QinDynasty() {
        super("Qin Dynasty");
    }

    public Hills getHills() {
        return hills;
    }

    @Override
    public String explore() {
        if (!(hills.replenishGame())) {
            int foodFound = hills.hunt().getHealth();
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
