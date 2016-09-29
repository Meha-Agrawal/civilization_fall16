public class Treasury {
    private int goldCoins = 200;

    public int getCoins() {
        return goldCoins;
    }
    public boolean spend(int cost) {
        if (goldCoins >= cost) {
            goldCoins -= cost;
            return true;
        }
        return false;
    }
    public void earn(int earned) {
        goldCoins += earned;
    }

}
