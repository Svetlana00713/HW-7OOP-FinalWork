package family_tree.model.tree;

import family_tree.model.person.Person;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class Tree<E extends TreeNode<E>> implements Serializable, Iterable<E> {
    private List<E> personList;

    public Tree() {
        this(new ArrayList<>());
    }

    public Tree(List<E> personList) {
        this.personList = personList;
    }

    public boolean add(E person){
        if (person == null) {
            return false;
        }
        if (!personList.contains(person)){
            personList.add(person);

            addToParents(person);
            addToKids(person);

            return true;
        }
        return false;
    }

    private void addToParents(E person){
        for (E parent: person.getParents()){
            parent.addKid(person);
        }
    }

    private void addToKids(E person){
        for (E kid: person.getKids()){
            kid.addParent(person);
        }
    }

    public Person getByName(String name) {
        E result = null;
        for (int i = 0; i < personList.size(); i++) {
            if (this.personList.get(i).getName().equals(name)) {
                result = this.personList.get(i);
            }
        }
        return (Person) result;
    }


    @Override
    public String toString() {
        return getInfo();
    }

    public String getInfo() {
        StringBuilder sb = new StringBuilder();
        sb.append("В дереве ");
        sb.append(personList.size());
        sb.append(" объектов: \n");
        for (E person : personList) {
            sb.append(person);
            sb.append("\n");
        }
        return sb.toString();
    }

    public void sortedByName() {
        personList.sort(new ComparatorByName<>());
    }

    public void sortedByAge() {
        personList.sort(new ComparatorByAge<>());
    }

    @Override
    public Iterator<E> iterator() {
        return new TreeIterator<>(personList);
    }
}
