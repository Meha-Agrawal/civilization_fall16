package model;

public class MeleeUnit extends MilitaryUnit{

    public MeleeUnit(Civilization owner) {
        super(100, owner, 10, 10, 14, 5, 0, 30);
    }

    @Override
    public String toString() {
        return "Melee Unit. " + super.toString();
    }

    @Override
    public char symbol() {
        return 'M';
    }

    @Override
    public void battle(MapObject m) {
        m.damage(getDamage());
        if(!m.isDestroyed() && (m instanceof MeleeUnit)
        || (m instanceof HybridUnit)) {
            this.damage(((MilitaryUnit) m).getDamage());
        }
    }
}
