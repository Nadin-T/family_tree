package view.commands;

public class ExitCommand implements Command{
    @Override
    public void execute() {
        System.out.println("Работа программы завершена.");
        System.exit(0);
    }
}
