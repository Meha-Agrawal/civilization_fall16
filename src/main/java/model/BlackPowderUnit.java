package model;
public class BlackPowderUnit extends SiegeUnit {

    public BlackPowderUnit(Civilization owner) {
        super(owner);
    }

    @Override
    public char symbol() {
        return 'B';
    }

    @Override
    public String toString() {
        return "Black Powder Unit. " + super.toString();
    }

    @Override
    public void battle(MapObject m) {
        m.damage(this.getDamage());
    }
}
