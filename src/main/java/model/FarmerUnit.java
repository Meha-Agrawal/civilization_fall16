package model;
public class FarmerUnit extends Unit implements Convertable {

    public FarmerUnit(Civilization owner) {
        super(owner);
    }

    @Override
    public String toString() {
        return "Farmers. " + super.toString();
    }

    @Override
    public char symbol() {
        return 'f';
    }

    @Override
    public Building convert() {
        return getOwner().getFarm();
    }

    @Override
    public boolean canConvert(TileType type) {
        if(type == TileType.PLAINS) {
            return true;
        } else {
            return false;
        }
    }
}
