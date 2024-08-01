package model.human;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Human implements Serializable {
    private long id;
    private String name;
    private Gender gender;
    private LocalDate dateOfBirth;
    private Human father;
    private Human mother;
    private Human spouse;
    private List<Human> children;

    public Human(String name, Gender gender, LocalDate dateOfBirth) {
        this.id = -1; // Идентификатор человека, по умолчанию -1, пока не присвоен
        this.name = name;
        this.gender = gender;
        this.dateOfBirth = dateOfBirth;
        this.children = new ArrayList<>();
    }

    // Методы доступа для получения и изменения полей объекта Human
    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Gender getGender() {
        return gender;
    }

    public void setGender(Gender gender) {
        this.gender = gender;
    }

    public LocalDate getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(LocalDate dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    public Human getFather() {
        return father;
    }

    public void setFather(Human father) {
        this.father = father;
    }

    public Human getMother() {
        return mother;
    }

    public void setMother(Human mother) {
        this.mother = mother;
    }

    public Human getSpouse() {
        return spouse;
    }

    public void setSpouse(Human spouse) {
        this.spouse = spouse;
    }

    public List<Human> getChildren() {
        return children;
    }

    public void setChildren(List<Human> children) {
        this.children = children;
    }

    // Добавление ребенка
    public void addChild(Human child) {
        this.children.add(child);
        if (this.gender == Gender.Male) {
            child.setFather(this);
        } else if (this.gender == Gender.Female) {
            child.setMother(this);
        }
    }

    // Переопределение метода toString для удобства отладки
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(id).append(", Имя: ")
                .append(name).append(", Пол: ")
                .append(gender).append(", Дата рождения: ")
                .append(dateOfBirth).append(", ")
                .append("Родители: [");

        if (father != null) {
            sb.append(father.getName());
        }

        sb.append(", ");

        if (mother != null) {
            sb.append(mother.getName());
        }

        sb.append("], Дети: [");

        for (int i = 0; i < children.size(); i++) {
            sb.append(children.get(i).getName());
            if (i < children.size() - 1) {
                sb.append(", ");
            }
        }

        sb.append("]");

        return sb.toString();
    }
}
