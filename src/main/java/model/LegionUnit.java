package model;
public class LegionUnit extends MeleeUnit {

    public LegionUnit(Civilization owner) {
        super(owner);
        setDamage(((int) (1.5 * getDamage())));
    }

    @Override
    public String toString() {
        return "Legion. " + super.toString();
    }

    @Override
    public char symbol() {
        return 'L';
    }

    @Override
    public void battle(MapObject m) {
        m.damage(getDamage());
        if(!m.isDestroyed() && (m instanceof MeleeUnit)) {
            this.damage(((MilitaryUnit) m).getDamage());
        }
    }
}
