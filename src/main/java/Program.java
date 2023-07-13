import java.io.IOException;

public class Program {
    public static void main(String[] args) throws IOException, ClassNotFoundException {
        Tree tree = new Tree();
        Service service = new Service(tree);

        Person h1 = new Person("Victor Smirnov", Gender.Male, 1955);
        Person h2 = new Person("Marya Smirnova", Gender.Female, 1958);
        Person h3 = new Person("Elena Turova", Gender.Female, 1977, h1, h2);
        Person h4 = new Person("Fedor Turov", Gender.Male, 1970);

        tree.add(h1);
        tree.add(h2);
        tree.add(h3);
        tree.add(h4);

        System.out.println(tree.getInfo());
        System.out.println();
        System.out.print("Maria`s kids: " + tree.getKids("Maria"));
        System.out.println();

        System.out.print("Elena`s kids: " + tree.getKids("Elena"));
        System.out.println();


        File file = new File();
        file.save(tree);

        Tree tree2 = new Tree();
        tree2 = file.open();
        System.out.println(tree2.getInfo());
        System.out.println();

        System.out.println("People in the tree: ");
        for (Person person : tree) {
            System.out.println(person);
        }

        service.sortByName();

        System.out.println();
        System.out.println("Sorted people by name: ");
        for (Person person : tree) {
            System.out.println(person);
        }
        service.sortByYear();
        System.out.println();
        System.out.println("Sorted people by year: ");
        for (Person person : tree) {
            System.out.println(person);
        }

        Tree<Dog> tree_dog = new Tree();
        Service service2 = new Service(tree_dog);

        Dog d1 = new Dog("Bim", Gender.Male, 2020);
        Dog d2 = new Dog("Alvora", Gender.Female, 2019);
        Dog d3 = new Dog("Didi", Gender.Female, 2023, d1, d2);
        Dog d4 = new Dog("Alex", Gender.Male, 2022, d1, d2);

        tree_dog.add(d1);
        tree_dog.add(d2);
        tree_dog.add(d3);
        tree_dog.add(d4);

        System.out.println();
        System.out.println("Dogs in the tree: ");
        for (Dog dog : tree_dog) {
            System.out.println(dog);
        }

        service2.sortByName();

        System.out.println();
        System.out.println("Sorted dogs by name: ");
        for (Dog dog : tree_dog) {
            System.out.println(dog);
        }
        service2.sortByYear();
        System.out.println();
        System.out.println("Sorted dogs by year: ");
        for (Dog dog : tree_dog) {
            System.out.println(dog);
        }
    }
}







