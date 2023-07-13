import java.util.Collections;
public class Service<E extends Person> {
    private Tree<E> tree;

    public Service(Tree<E> tree) {
        this.tree = tree;
    }

    public void sortByName() {
        Collections.sort(tree.getPersonList(), new ComparatorByName());
    }

    public void sortByYear() {
        Collections.sort(tree.getPersonList(), new ComparatorByYear());
    }
}
