public class Strategy {
    private int strategyLevel;
    private static final int BATTLE_INCREASE = 10;
    private static final int SIEGE_INCREASE = 40;
    private boolean conquerTheWorld = false;

    public int getStrategyLevel() {
        return strategyLevel;
    }
    public void battle() {
        strategyLevel += BATTLE_INCREASE;
        if (strategyLevel > 180) {
            conquerTheWorld = true;
        }
    }

    public void siege() {
        strategyLevel += SIEGE_INCREASE;
        if (strategyLevel > 180) {
            conquerTheWorld = true;
        }
    }

    public boolean conqueredTheWorld() {
        return conquerTheWorld;
    }


}
