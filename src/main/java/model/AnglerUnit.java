package model;
public class AnglerUnit extends Unit implements Convertable {

    public AnglerUnit(Civilization owner) {
        super(owner);
    }

    @Override
    public String toString() {
        return "Anglers. " + super.toString();
    }

    @Override
    public char symbol() {
        return 'a';
    }

    @Override
    public Building convert() {
        return getOwner().getFishingShack();
    }

    @Override
    public boolean canConvert(TileType type) {
        if(type == TileType.WATER) {
            return true;
        } else {
            return false;
        }
    }
}
