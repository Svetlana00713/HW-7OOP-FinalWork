public class AddPeople extends Command {
    public AddPeople(Console console) {
        super(console);
    }

    @Override
    public String description() {
        return "Add new people";
    }

    @Override
    public void execute() {
        getConsole().AddPeople();
    }

}
