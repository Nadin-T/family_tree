import model.family_tree.FamilyTree;
import presenter.FamilyTreePresenter;
import view.ConsoleUI;

public class Main {
    public static void main(String[] args) {
        // Создаем объект FamilyTree для хранения семейного древа
        FamilyTree familyTree = new FamilyTree();

        // Создаем презентер, который будет управлять семейным древом
        FamilyTreePresenter presenter = new FamilyTreePresenter(familyTree);

        // Создаем консольный интерфейс для взаимодействия с пользователем
        ConsoleUI consoleUI = new ConsoleUI(presenter);

        // Запускаем консольный интерфейс
        consoleUI.start();
    }
}
