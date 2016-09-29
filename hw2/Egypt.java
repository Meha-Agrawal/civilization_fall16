public class Egypt {
    private Population population;
    private Treasury treasury;
    private CoalMine coalMine;
    private River river;
    private Technology technology;
    private Strategy strategy;
    private Desert desert;
    private Settlement[] settlements = new Settlement[10];
    private int settlementSize = 0;

    public Egypt() {
        population = new Population();
        treasury = new Treasury();
        coalMine = new CoalMine();
        river = new River("Nile");
        technology = new Technology();
        strategy = new Strategy();
        desert = new Desert();
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
    public Desert getDesert() {
        return desert;
    }

    public boolean settle(Settlement settlement) {
        if (settlementSize <= 10) {
            settlements[settlementSize] = settlement;
            settlementSize++;
            return true;
        } else {
            return false;
        }
    }



    public boolean buildPyramid(Settlement s) {
        if (s.build(treasury.getCoins(), population, 500, 100)) {
            treasury.spend(500);
            technology.increaseExperience(10);
            return true;
        }
        return false;
    }
    public void practiceHieroglyphics() {
        technology.improveWriting();
        population.increaseHappiness(10);
    }

}
