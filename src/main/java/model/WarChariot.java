package model;
public class WarChariot extends RangedUnit {

    public WarChariot(Civilization owner) {
        super(owner);
        setBaseEndurance(20);
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
