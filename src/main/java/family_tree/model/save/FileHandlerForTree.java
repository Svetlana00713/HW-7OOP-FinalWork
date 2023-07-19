package family_tree.model.save;

import family_tree.model.tree.Tree;
import family_tree.model.save.base.FileHandler;
import family_tree.model.person.Person;

import java.io.Serializable;

public class FileHandlerForTree extends FileHandler implements Writable{
    private String filePath = "tree.out";

    @Override
    public void setFilePath(String filePath) {
        this.filePath = filePath;
    }

    @Override
    public boolean save(Tree<Person> tree, String filePath) {
        return super.save(tree, filePath);
    }

    @Override
    public boolean save(Tree<Person> tree) {
        return false;
    }

    @Override
    public Tree<Person> read() {
        return (Tree<Person>)super.read(filePath);
    }
}
