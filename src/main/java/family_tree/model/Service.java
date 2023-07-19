package family_tree.model;

import family_tree.model.tree.Tree;
import family_tree.model.person.Gender;
import family_tree.model.person.Person;
import family_tree.model.save.Writable;

import java.time.LocalDate;


public class Service {
    private Writable writable;
    private Tree<Person> activeTree;

    public Service(Tree<Person> activeTree) {
        this.activeTree = activeTree;
    }

    public Service(){
        activeTree = new Tree<>();
    }

    public boolean save(){
        if (writable == null){
            return false;
        }
        return writable.save(activeTree);
    }

    public boolean load(){
        if (writable == null){
            return false;
        }
        activeTree = writable.read();
        return true;
    }

    public String addPerson(String name, String genderString, String birthDate,
                           String father, String mother){
        Person father = activeTree.getByName(father);
        Person mother = activeTree.getByName(mother);
        Gender gender = Gender.valueOf(genderString);
        LocalDate personBirthDate = LocalDate.parse(birthDate);
        Person person = new Person(name, gender, personBirthDate, father, mother);
        activeTree.add(person);
        return "Человек успешно добавлен в дерево";
    }

    public void setWritable(Writable writable) {
        this.writable = writable;
    }

    public void sortedByName(){
        activeTree.sortedByName();
    }

    public void sortedByAge(){
        activeTree.sortedByAge();
    }

    public String getPersonList() {
        return activeTree.getInfo();
    }
}
