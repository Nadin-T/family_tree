package view.commands;

import model.human.Human;
import presenter.FamilyTreePresenter;

import java.util.Scanner;

public class EstablishFamilyRelationshipsCommand implements Command{
    private FamilyTreePresenter presenter;
    private Scanner scanner;

    public EstablishFamilyRelationshipsCommand(FamilyTreePresenter presenter, Scanner scanner) {
        this.presenter =presenter;
        this.scanner = scanner;
    }

    @Override
    public void execute() {
        System.out.println("Установка семейных связей:");

        System.out.print("Введите id родителя: ");
        long parentId = scanner.nextLong();
        Human parent = presenter.findHumanById(parentId);
        if (parent == null) {
            System.out.println("Человек с таким id не найден.");
            return;
        }

        System.out.print("Введите id ребенка: ");
        long childId = scanner.nextLong();
        Human child = presenter.findHumanById(childId);
        if (child == null) {
            System.out.println("Человек с таким id не найден.");
            return;
        }

        parent.addChild(child);
        System.out.println("Семейная связь установлена.");
    }
}
