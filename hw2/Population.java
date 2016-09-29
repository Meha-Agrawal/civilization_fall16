import java.util.Random;

public class Population {
    private Random rand = new Random();
    private int warriors = 50;
    private int civilians = 50;
    private int happiness = 200;

    public void increaseHappiness(int inc) {
        happiness += inc;
    }
    public void decreaseHappiness(int dec) {
        happiness += dec;
    }
    public boolean canWork(int num) {
        if (civilians >= num) {
            civilians -= num;
            return true;
        } else {
            return false;
        }
    }
    public boolean canBattle() {
        if (warriors > rand.nextInt(100)) {
            warriors -= rand.nextInt(20);
            return true;
        }
        return false;
    }
    public Game hunt(Hills h) {
        return (h.hunt());
    }
    public Fish fish(River r) {
        return (r.getFish());
    }

    public boolean canCook(Game g, CoalMine c) {
        if (c.getCoal() >= 40) {
            warriors += 40;
            civilians += 60;
            for (int i = 0; i < 5; i++) {
                c.burn();
            }
            return true;
        } else {
            return false;
        }
    }

    public boolean canCook(Fish f, CoalMine c) {
        if (c.getCoal() >= 40) {
            warriors += 10;
            civilians += 15;
            for (int i = 0; i < 5; i++) {
                c.burn();
            }
            return true;
        } else {
            return false;
        }
    }

    public int getCivilians() {
        return civilians;
    }
}
