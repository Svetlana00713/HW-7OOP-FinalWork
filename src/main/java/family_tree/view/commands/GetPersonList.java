package family_tree.view.commands;

public class GetPersonList {
    private Console console;

    public GetPersonList(Console console) {
        this.console = console;
    }

    public String getDescription() {
        return "Get persons";
    }

    public void execute() {
        console.getPersonList();
    }
}

