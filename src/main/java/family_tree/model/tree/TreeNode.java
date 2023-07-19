package family_tree.model.tree;

import java.time.LocalDate;
import java.util.List;

public interface TreeNode<T> {
    T getFather();
    T getMother();
    boolean addKid(T human);
    boolean addParent(T human);
    String getName();
    LocalDate getDeathDate();
    LocalDate getBirthDate();
    List<T> getParents();
    List<T> getKids();
    T getSpouse();
    void setSpouse(T person);

    String toString(String getInfo);
}
