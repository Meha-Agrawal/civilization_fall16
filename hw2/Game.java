public class Game {
    private int healthIncrease;

    public Game() {
        this(20);
    }
    public Game(int increase) {
        healthIncrease = increase;
    }
    public int getHealth() {
        return healthIncrease;
    }
}
