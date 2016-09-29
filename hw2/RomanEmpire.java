public class RomanEmpire {
    private Population population;
    private Treasury treasury;
    private CoalMine coalMine;
    private River river;
    private Technology technology;
    private Strategy strategy;
    private Hills hills;
    private Settlement[] settlements = new Settlement[10];
    private int settlementSize = 0;

    public RomanEmpire() {
        population = new Population();
        treasury = new Treasury();
        coalMine = new CoalMine();
        river = new River("Euphrates");
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
    public int getNumSettlements() {
        return settlementSize;
    }
    public Settlement[] getSettlements() {
        return settlements;
    }
    public Hills getHills() {
        return hills;
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

    public boolean buildAqueduct(Settlement s) {
        if (s.build(treasury.getCoins(), population, 250, 130)) {
            treasury.spend(250);
            technology.increaseExperience(10);
            return true;
        }
        return false;
    }

    public boolean buildBathHouse(Settlement s) {
        if (s.build(treasury.getCoins(), population, 110, 20)) {
            treasury.spend(110);
            technology.increaseExperience(10);
            return true;
        }
        return false;
    }

    public boolean buildVilla(Settlement s) {
        if (s.build(treasury.getCoins(), population, 80, 15)) {
            treasury.spend(80);
            technology.increaseExperience(5);
            return true;
        }
        return false;
    }

    public void studyPhilosophy() {
        population.decreaseHappiness(10);
        if (population.getHappiness() < 0) {
            population.increaseHappiness(10);
        }
    }
}
