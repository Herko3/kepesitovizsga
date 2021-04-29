package hu.nive.ujratervezes.kepesitovizsga.army;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Army {

    private List<MilitaryUnit> units = new ArrayList<>();

    public void addUnit(MilitaryUnit militaryUnit) {
        units.add(militaryUnit);
    }

    public void damageAll(int damage) {
        units.forEach(m -> m.sufferDamage(damage));

        units = units.stream()
                .filter(MilitaryUnit::isReadyToFight)
                .collect(Collectors.toList());
    }

    public int getArmyDamage() {
        return units.stream()
                .mapToInt(MilitaryUnit::doDamage)
                .sum();
    }

    public int getArmySize() {
        return units.size();
    }
}
