package hu.nive.ujratervezes.kepesitovizsga.army;

public class HeavyCavalry extends MilitaryUnit {

    private int numberOfAttacks;

    public HeavyCavalry() {
        super(150, 20, true);
    }

    @Override
    protected int doDamage() {
        int dealtDamage;
        if (numberOfAttacks == 0) {
            dealtDamage = damage * 3;
        } else {
            dealtDamage = damage;
        }
        numberOfAttacks++;
        return dealtDamage;
    }

}
