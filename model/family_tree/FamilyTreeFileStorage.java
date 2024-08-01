package model.family_tree;

import java.io.*;

public class FamilyTreeFileStorage implements FamilyTreeStorage{
    @Override
    public void saveFamilyTree(FamilyTree familyTree, String fileName) {
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(fileName))) {
            oos.writeObject(familyTree);
            System.out.println("Family tree saved successfully to " + fileName);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public FamilyTree loadFamilyTree(String fileName) {
        FamilyTree familyTree = null;
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(fileName))) {
            familyTree = (FamilyTree) ois.readObject();
            System.out.println("Family tree loaded successfully from " + fileName);
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
        return familyTree;
    }
}
