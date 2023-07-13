public class ShowTree extends Command {

    public ShowTree(Console console) {
        super(console);

    }

    @Override
    public String description() {
        return "Show tree";
    }

    @Override
    public void execute() {
        getConsole().ShowTree();
    }
}
