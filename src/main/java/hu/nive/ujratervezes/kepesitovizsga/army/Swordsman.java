package hu.nive.ujratervezes.kepesitovizsga.army;

public class Swordsman extends MilitaryUnit{

    private boolean hasShield = true;

    public Swordsman(boolean armor) {
        super(100, 10, armor);
    }

    @Override
    protected int doDamage() {
        return damage;
    }

    @Override
    public void sufferDamage(int damage) {
        if(hasShield){
            damage = 0;
            hasShield = false;
        }
        super.sufferDamage(damage);
    }
}
