package view.commands;

import model.family_tree.FamilyTree;
import presenter.FamilyTreePresenter;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;

public class LoadFamilyTreeFromFileCommand implements Command {
    private FamilyTreePresenter presenter;

    public LoadFamilyTreeFromFileCommand(FamilyTreePresenter presenter) {
        this.presenter = presenter;
    }

    @Override
    public void execute() {


        File file = new File("family_tree.ser");
        if (!file.exists()){
            System.out.println("Файл family_tree.ser не существует.");
            return;
        }
        try {
            FileInputStream fileIn = new FileInputStream("family_tree.ser");
            ObjectInputStream objectIn = new ObjectInputStream(fileIn);
            presenter.setFamilyTree((FamilyTree) objectIn.readObject());
            objectIn.close();
            System.out.println("Древо загружено из файла family_tree.ser");
        } catch (IOException | ClassNotFoundException e) {
            System.out.println("Ошибка при загрузке дерева из файла.");
            e.printStackTrace();
        }
    }
}
