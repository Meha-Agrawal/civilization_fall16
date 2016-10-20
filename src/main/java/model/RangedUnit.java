package model;
public class RangedUnit extends MilitaryUnit {

    public RangedUnit(Civilization owner) {
        super(100, owner, 10, 10, 14, 5, 0, 30);
    }

    @Override
    public char symbol() {
        return 'R';
    }

    @Override
    public String toString() {
        return "Ranged Unit. " + super.toString();
    }

    @Override
    public void battle(MapObject m) {
        m.damage(this.getDamage());
        if (!m.isDestroyed() && ((m instanceof HybridUnit)
            || (m instanceof RangedUnit))) {
            this.damage(((MilitaryUnit) m).getDamage());
        }
    }

}
