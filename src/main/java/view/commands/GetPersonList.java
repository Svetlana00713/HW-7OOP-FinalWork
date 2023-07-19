package view.commands;

import view.Console;

public class GetPersonList {
    private Console console;

    public GetPersonList(Console console) {
        this.console = console;
    }

    public String getDescription() {
        return "Get by name";
    }

    public void execute() {
        console.getPersonList();
    }
}

