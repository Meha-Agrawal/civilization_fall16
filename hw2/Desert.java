import java.util.Scanner;
import java.util.Random;

public class Desert {
    private Scanner scan = new Scanner(System.in);
    private Random  rand = new Random();

    public int findTreasure() {
        int lost = rand.nextInt(10);

        boolean gotLost = false;
        if (lost == 0) {
            gotLost = true;
        }
        while (gotLost) {
            if (!lost()) {
                gotLost = false;
            }
        }
        return 1 + rand.nextInt(501);
    }

    public boolean lost() {
        System.out.println("You have gotten lost! Press 1 to try escaping the"
            + " Desert.\nHopefully you can make it out alive.");
        int move = scan.nextInt();
        return (move == 1) ? false : true;
    }
}
