package presenter;

import model.family_tree.FamilyTree;
import model.family_tree.FamilyTreeFileStorage;
import model.human.Gender;
import model.human.Human;
import model.human.HumanBuilder;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class FamilyTreePresenter {
    private FamilyTree familyTree;
    private FamilyTreeFileStorage fileStorage;

    public FamilyTreePresenter(FamilyTree familyTree) {
        this.familyTree = familyTree;
        this.fileStorage = new FamilyTreeFileStorage();
    }

    public Human createNewHuman(String name, Gender gender, LocalDate dateOfBirth) {
        long newId = generateUniqueId(); // Генерация уникального ID
        HumanBuilder builder = new HumanBuilder()
                .withName(name)
                .withGender(gender)
                .withDateOfBirth(dateOfBirth);

        Human newHuman = builder.build();
        newHuman.setId(newId); // Установка сгенерированного ID
        return newHuman;
    }

    private long generateUniqueId() {
        return familyTree.getHumans().size() + 1;
    }

    public void addHumanToTree(Human human) {
        familyTree.addHuman(human);
    }

    public void removeHumanFromTree(Human human) {
        familyTree.removeHuman(human);
    }

    public Human findHumanById(long id) {
        return familyTree.findHumanById(id);
    }

    public void displayFamilyTree() {
        // Реализация вывода всего древа на консоль
        for(Human human : familyTree.getHumans()) {
            if (human.getFather() == null && human.getMother() == null) {
                displayHuman(human, 0); // начинаем с корня дерева
            }
        }
    }

    public void displayHuman(Human human, int level) {
        // Вывод информации о человеке с отступом, соответствующим его уровню в древе
        StringBuilder indent = new StringBuilder();
        for (int i = 0; i < level; i++) {
            indent.append("    "); // отступ в 4 пробела для каждого уровня
        }
        System.out.println(indent.toString() + human.getName() + " (" + human.getGender() + ") - " + human.getDateOfBirth());

        // Рекурсивно вызываем displayHuman для каждого ребенка текущего человека
        for (Human child : human.getChildren()) {
            displayHuman(child, level + 1);
        }

    }

    public void displayHumanDetails(Human human) {
        System.out.println("ID: " + human.getId());
        System.out.println("Имя: " + human.getName());
        System.out.println("Пол: " + human.getGender());
        System.out.println("Дата рождения: " + human.getDateOfBirth());

        if (human.getFather() != null) {
            System.out.println("Отец: " + human.getFather().getName());
        }

        if (human.getMother() != null) {
            System.out.println("Мать: " + human.getMother().getName());
        }

        if (!human.getChildren().isEmpty()) {
            StringBuilder childrenList = new StringBuilder();
            for (Human child : human.getChildren()) {
                childrenList.append(child.getName()).append(", ");
            }
            childrenList.delete(childrenList.length() -2, childrenList.length()); // удаление лишней запятой
            System.out.println("Дети: " + childrenList.toString());
        }
    }

    public void saveFamilyTreeToFile(String fileName) {
        fileStorage.saveFamilyTree(familyTree, fileName);
    }

    public FamilyTree loadFamilyTreeFromFile(String fileName) {
        return fileStorage.loadFamilyTree(fileName);
    }

    public List<Human> findHumansByName(String name) {
        List<Human> foundHumans = new ArrayList<>();
        for (Human human : familyTree.getHumans()) {
            if (human.getName().equals(name)) {
                foundHumans.add(human);
            }
        }
        return foundHumans;
    }

    public FamilyTree getFamilyTree() {
        return familyTree;
    }

    public void setFamilyTree(FamilyTree familyTree) {
        this.familyTree = familyTree;
    }
}
