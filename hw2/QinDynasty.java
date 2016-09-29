public class QinDynasty {
    private Population population;
    private Treasury treasury;
    private CoalMine coalMine;
    private River river;
    private Technology technology;
    private Strategy strategy;
    private Hills hills;
    private Settlement[] settlements = new Settlement[10];
    private int settlementSize = 0;

    public QinDynasty() {
        population = new Population();
        treasury = new Treasury();
        coalMine = new CoalMine();
        river = new River("Yangtze");
        technology = new Technology();
        strategy = new Strategy();
        hills = new Hills();
    }

    public Population getPopulation() {
        return population;
    }
    public Treasury getTreasury() {
        return treasury;
    }
    public CoalMine getCoalMine() {
        return coalMine;
    }
    public River getRiver() {
        return river;
    }
    public Technology getTechnology() {
        return technology;
    }
    public Strategy getStrategy() {
        return strategy;
    }
    public Settlement[] getSettlements() {
        return settlements;
    }
    public int getNumSettlements() {
        return settlementSize;
    }
    public Hills getHills() {
        return hills;
    }

    public boolean settle(Settlement settlement) {
        if (settlementSize <= 9) {
            settlements[settlementSize] = settlement;
            settlementSize++;
            return true;
        } else {
            return false;
        }
    }

    public boolean buildWall(Settlement s) {
        if (s.build(treasury.getCoins(), population, 1000, 100)) {
            treasury.spend(1000);
            technology.increaseExperience(10);
            return true;
        }
        return false;
    }
    public boolean buildHouse(Settlement s) {
        if (s.build(treasury.getCoins(), population, 30, 8)) {
            treasury.spend(30);
            technology.increaseExperience(10);
            return true;
        }
        return false;
    }
    public void establishLegalism() {
        population.decreaseHappiness(20);
        if (population.getHappiness() > 0) {
            technology.philosophize();
        } else {
            population.increaseHappiness(20);
        }
    }


}
