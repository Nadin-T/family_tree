package model.family_tree.comparators;

import model.human.Human;

import java.util.Comparator;

public class FamilyTreeComparatorByName implements Comparator<Human> {
    @Override
    public int compare(Human h1, Human h2) {
        return h1.getName().compareTo(h2.getName());
    }
}
