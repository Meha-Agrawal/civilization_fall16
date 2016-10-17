package model;
public class SiegeUnit extends MilitaryUnit {

    public SiegeUnit(Civilization owner) {
        super(200, owner, 5, 10, 14, 5, 10, 6);
    }

    @Override
    public char symbol() {
        return 'S';
    }

    @Override
    public void battle(MapObject m) {
        if (m instanceof Building) {
            m.damage(this.getDamage());
        }
    }

    @Override
    public void attack(MapObject m) {
        getOwner().getStrategy().siege();
        battle(m);
        setCanAttack(false);
    }

    @Override
    public String toString() {
        return "Siege Unit. " + super.toString();
    }

}
