package view.commands;

import presenter.FamilyTreePresenter;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;

public class SaveFamilyTreeToFileCommand implements Command {
    private FamilyTreePresenter presenter;

    public SaveFamilyTreeToFileCommand(FamilyTreePresenter presenter) {
        this.presenter = presenter;
    }

    @Override
    public void execute() {
        try {
            FileOutputStream fileOut = new FileOutputStream("family_tree.ser");
            ObjectOutputStream objectOut = new ObjectOutputStream(fileOut);
            objectOut.writeObject(presenter.getFamilyTree());
            objectOut.close();
            System.out.println("Древо сохранено в файле family_tree.ser");
        } catch (IOException e) {
            System.out.println("Ошибка при сохранении дерева в файл.");
            e.printStackTrace();
        }
    }
}
