public class GetByName extends Command {
    public GetByName(Console console) {
        super(console);
    }

    @Override
    public String description() {
        return "Get by name";
    }

    @Override
    public void execute() {
        getConsole().GetByName();
    }
}
