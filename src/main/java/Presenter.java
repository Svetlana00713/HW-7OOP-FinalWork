import java.util.List;
public class Presenter {
    private View view;
    private Tree tree;
    private List answer;
    private Person p;

    public Presenter(View view, Tree tree) {
        this.view = view;
        this.tree = tree;
        view.setPresenter(this);
    }
    public void ShowTree() {
        answer = tree.getInfo();
        view.print(answer);
    }
    public void GetByName(String name){
        answer.clear();
        answer.add(tree.getByName(name));
        view.print(answer);
    }
    public void AddPeople(String name,int year){
        p = new Person(name, year);
        tree.add(p);
        view.print(tree.getInfo());
    }
}
