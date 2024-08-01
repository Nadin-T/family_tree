package model.family_tree;

import model.family_tree.comparators.FamilyTreeComparatorByBirthDate;
import model.family_tree.comparators.FamilyTreeComparatorByName;
import model.human.Human;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class FamilyTree implements Serializable {

    private List<Human> humans;

    public FamilyTree() {
        this.humans = new ArrayList<>();
    }

    public void addHuman(Human human) {
        if (!humans.contains(human)) {
            humans.add(human);
        }
    }

    public void removeHuman(Human human) {
        humans.remove(human);
    }

    public Human findHumanById(long id) {
        for (Human human : humans) {
            if (human.getId() == id) {
                return human;
            }
        }
        return null;
    }

    public List<Human> findHumansByName(String name) {
        List<Human> result = new ArrayList<>();
        for (Human human : humans) {
            if (human.getName().equals(name)) {
                result.add(human);
            }
        }
        return result;
    }

    // Возвращает отсортированный список людей по дате рождения
    public List<Human> getHumansSortedByBirthDate() {
        List<Human> sortedList = new ArrayList<>(humans);
        sortedList.sort(new FamilyTreeComparatorByBirthDate());
        return sortedList;
    }

    // Возвращает отсортированный список людей по имени
    public List<Human> getHumansSortedByName() {
        List<Human> sortedList = new ArrayList<>(humans);
        sortedList.sort(new FamilyTreeComparatorByName());
        return sortedList;
    }

    public List<Human> getHumans() {
        return humans;
    }

    public void setHumans (List<Human>humans){this.humans = humans;}
}
