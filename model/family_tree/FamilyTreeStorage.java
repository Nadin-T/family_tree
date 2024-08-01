package model.family_tree;
public interface FamilyTreeStorage {
    void saveFamilyTree(FamilyTree familyTree, String fileName);

    FamilyTree loadFamilyTree(String fileName);
}
