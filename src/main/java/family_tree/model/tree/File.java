package family_tree.model.tree;

import java.io.Serializable;
import java.io.*;

public class File implements Serializable {
    public Tree obj;
    public void save(Tree obj) throws IOException, ClassNotFoundException {
        this.obj = obj;
        ObjectOutputStream objectOutputStream = new ObjectOutputStream(new FileOutputStream("Tree.out"));
        objectOutputStream.writeObject(obj);
        objectOutputStream.close();
        System.out.println("File saved");
    }
    public Tree open() throws IOException, ClassNotFoundException {
        ObjectInputStream objectInputStream = new ObjectInputStream(new FileInputStream("Tree.out"));
        this.obj = (Tree) objectInputStream.readObject();
        System.out.println("File opened");
        objectInputStream.close();
        return this.obj;
    }
}
