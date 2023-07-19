package family_tree;

import family_tree.model.Service;
import family_tree.model.person.Gender;
import family_tree.model.person.Person;
import family_tree.model.save.FileHandlerForTree;
import family_tree.model.tree.Tree;
import view.Console;
import view.View;

import java.time.LocalDate;

public class Program {
    public static void main(String[] args) {
        Tree<Person> tree = new Tree();

        Person h1 = new Person("Victor Smirnov", Gender.Male, LocalDate.of(1955,5,18),null, null);
        Person h2 = new Person("Marya Smirnova", Gender.Female, LocalDate.of(1958,11,23), null, null);
        Person h3 = new Person("Elena Turova", Gender.Female, LocalDate.of(1977, 3, 13), h1, h2);
        Person h4 = new Person("Fedor Turov", Gender.Male, LocalDate.of(1970, 8,9), null, null);

        tree.add(h1);
        tree.add(h2);
        tree.add(h3);
        tree.add(h4);

        Person kid = new Person("Ольга Бойко", Gender.Female, LocalDate.of(1997, 9, 1));
        kid.addParent(h3);
        kid.addParent(h4);

        tree.add(kid);

        System.out.println(tree);

        Service service = new Service(tree);
        service.setWritable(new FileHandlerForTree());
        service.save();

        View view = new Console();
        view.start();
    }
}




