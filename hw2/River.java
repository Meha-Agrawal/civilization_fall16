import java.util.Random;
public class River {
    private String name;
    private Fish[] fish = new Fish[5];
    private Random forFish = new Random();
    private int size = 0;

    public River(String n) {
        name = n;
        for (int i = 0; i < 5; i++) {
            fish[i] = new Fish(forFish.nextInt(5));
            size++;
        }
    }
    public String getName() {
        return name;
    }
    public Fish getFish() {
        if (size != 0) {
            Fish tempFish = fish[size - 1];
            fish[size - 1] = null;
            size--;
            return tempFish;
        } else {
            return null;
        }
    }
    public boolean replenishFish() {
        if (size == 0) {
            for (int i = 0; i < 5; i++) {
                fish[i] = new Fish(5 * forFish.nextInt());
                size++;
            }
            return true;
        } else {
            return false;
        }
    }
}
