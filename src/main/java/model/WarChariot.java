package model;
public class WarChariot extends RangedUnit {

    public WarChariot(Civilization owner) {
        super(owner);
    }

    @Override
    public String toString() {
        return "War Chariot Unit. " + super.toString();
    }

    @Override
    public char symbol() {
        return 'W';
    }
}
