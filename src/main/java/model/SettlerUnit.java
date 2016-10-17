package model;
public class SettlerUnit extends Unit implements Convertable {
    private String townName;

    public SettlerUnit(Civilization owner, String tName) {
        super(owner);
        townName = tName;
    }

    @Override
    public String toString() {
        return "Settlers " + townName + " " + super.toString();
    }

    @Override
    public char symbol() {
        return 's';
    }

    @Override
    public Building convert() {
        return getOwner().getSettlement(townName);
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
