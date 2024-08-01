package model.family_tree.comparators;

import model.human.Human;

import java.util.Comparator;

public class FamilyTreeComparatorByBirthDate implements Comparator<Human> {
    @Override
    public int compare(Human h1, Human h2) {
        return h1.getDateOfBirth().compareTo(h2.getDateOfBirth());
    }
}
