import java.util.Iterator;
import java.util.List;

public class PersonIterator <E> implements Iterator<E>{
    private List<E> persons;
    private int index;

    public PersonIterator(List<E> p) {
        this.persons = p;
    }

    @Override
    public boolean hasNext() {
        // TODO Auto-generated method stub
        return index < persons.size();
    }

    @Override
    public E next() {
        // TODO Auto-generated method stub
        return persons.get(index++);
    }

    @Override
    public void remove() {
        // TODO Auto-generated method stub
    }
}
