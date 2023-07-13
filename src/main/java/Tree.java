import java.util.ArrayList;
import java.util.List;
import java.io.*;
import java.util.Collection;
import java.util.Collections;
import java.util.Iterator;

public class Tree<E extends Person> implements Serializable, Iterable<E> {
    private List<E> persons;
    private Writable writable;
    private Person result;
    public Tree(Writable writable) {
        this.writable = writable;
    }
    public void setWritable(Writable writable) {
        this.writable = writable;
    }
    @Override
    public Iterator<E> iterator() {
        // TODO Auto-generated method stub
        return new PersonIterator<E>(persons);
    }
    public Tree() {
        this(new ArrayList<>());
    }
    private Tree(List<E> persons) {
        this.persons = persons;
    }
    public void add(E p) {
        persons.add(p);
    }
    public List<E> getPersonList() {
        return persons;
    }
    public List<E> getInfo() {
        List res = new ArrayList();
        String str;
        for (int i = 0; i < persons.size(); i++) {
            str = persons.get(i).toString();
            res.add(str);
        }
        return res;
    }

        public Person getByName(String name){
            for (int i = 0; i < persons.size(); i++) {
                if (this.persons.get(i).getName().equals(name))
                    result = this.persons.get(i);
            }
            return result;
        }

        public List <E> getKids(String name){
            List<E> kids = new ArrayList();
            for (int i = 0; i < persons.size(); i++) {
                if (this.persons.get(i).dadOf() != null) if (this.persons.get(i).dadOf().getName().equals(name)) {
                    kids.add(this.persons.get(i));
                }
                if (this.persons.get(i).momOf() != null) {
                    if (this.persons.get(i).momOf().getName().equals(name)) {
                        kids.add(this.persons.get(i));
                    }
                }
                if (this.persons.get(i).momOf() != null) {
                    if (this.persons.get(i).momOf().getName().equals(name)) {
                        kids.add(this.persons.get(i));
                    }
                }
            }
            return kids;
        }
    }


