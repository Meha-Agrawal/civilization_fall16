package model;
public class Coliseum extends Landmark {

    public Coliseum(Civilization owner) {
        super(owner);
    }

    public String toString() {
        return "Coliseum. " + super.toString();
    }

    @Override
    public void invest() {
        super.invest();
        getOwner().increaseHappiness(50);
    }
}
