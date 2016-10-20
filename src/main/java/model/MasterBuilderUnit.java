package model;
public class MasterBuilderUnit extends Unit implements Convertable {

    public MasterBuilderUnit(Civilization owner) {
        super(owner);
    }

    @Override
    public String toString() {
        return "Master Builders. " + super.toString();
    }

    @Override
    public char symbol() {
        return 'm';
    }

    @Override
    public Building convert() {
        return getOwner().getLandmark();
    }

    @Override
    public boolean canConvert(TileType type) {
        return type == TileType.PLAINS;
    }
}
