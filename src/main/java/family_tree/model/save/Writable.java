package family_tree.model.save;

import family_tree.model.person.Person;
import family_tree.model.tree.Tree;

import java.io.Serializable;

public interface Writable {
    boolean save(Tree<Person> tree);
    Tree<Person> read();
    void setFilePath(String filePath);

    boolean save(Serializable serializable, String filePath);

    Object read(String filePath);
}



