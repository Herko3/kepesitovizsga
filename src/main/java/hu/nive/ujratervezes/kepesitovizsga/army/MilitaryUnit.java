package hu.nive.ujratervezes.kepesitovizsga.army;

public abstract class MilitaryUnit {

    protected int hitPoints;
    protected int damage;
    protected boolean armor;

    protected MilitaryUnit(int hitPoints, int damage, boolean armor) {
        this.hitPoints = hitPoints;
        this.damage = damage;
        this.armor = armor;
    }

    protected abstract int doDamage();

    public void sufferDamage(int damage) {
        if (armor) {
            hitPoints -= damage / 2;
        } else {
            hitPoints -= damage;
        }
    }

    public boolean isReadyToFight() {
        return hitPoints > 25;
    }

    public int getHitPoints() {
        return hitPoints;
    }

    public int getDamage() {
        return damage;
    }
}
