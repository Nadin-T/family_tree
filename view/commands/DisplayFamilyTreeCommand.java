package view.commands;

import presenter.FamilyTreePresenter;

public class DisplayFamilyTreeCommand implements Command{
    private FamilyTreePresenter presenter;

    public DisplayFamilyTreeCommand(FamilyTreePresenter presenter) {
        this.presenter = presenter;
    }

    @Override
    public void execute() {
        presenter.displayFamilyTree();
    }
}
