package model;

class RomanEmpire extends Civilization{
    private Hills hills = new Hills();

    public RomanEmpire() {
        super("Roman");
    }

    public hills getHills() {
        return hills;
    }

    @Override
    public String explore() {
        int resourcesFound = hills.mineCoal();
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
