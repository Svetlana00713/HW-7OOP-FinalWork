package family_tree.model.person;

import family_tree.model.tree.TreeNode;

import java.util.List;
import java.io.Serializable;
import java.time.LocalDate;
import java.time.Period;
import java.util.ArrayList;

public class Person implements Serializable, TreeNode<Person> {
    private String name;
    private Gender gender;
    private LocalDate birthDate;
    private LocalDate deathDate;
    private List<Person> parents;
    private Person father;
    private Person mother;
    private Person spouse;
    private List<Person> kids;

    public Person(String name, Gender gender, LocalDate birthDate, LocalDate deathDate, Person father, Person mother) {
        this.name = name;
        this.gender = gender;
        this.birthDate = birthDate;
        this.deathDate = deathDate;
        parents = new ArrayList<>();
        if (father != null){
            parents.add(father);
        }
        if (mother != null){
            parents.add(mother);
        }
        kids = new ArrayList<>();
    }

    public Person(String name, Gender gender, Person father, Person mother) {
        this.name = name;
        this.gender = gender;
        this.father = father;
        this.mother = mother;
    }
    public Person(String name, Gender gender, LocalDate birthDate) {
        this.name = name;
        this.gender = gender;
        this.birthDate = birthDate;
        this.deathDate = null;
        this.father = null;
        this.mother = null;
    }
    public Person(String name, Gender gender, LocalDate birthDate, Person father, Person mother) {
        this.name = name;
        this.gender = gender;
        this.birthDate = birthDate;
        this.deathDate = null;
        this.father = father;
        this.mother = mother;
    }

    public boolean addKid(Person kid){
        if (!kids.contains(kid)){
            kids.add(kid);
            return true;
        }
        return false;
    }

    public List<Person> getKids() {
        return kids;
    }

    public boolean addParent(Person parent){
        if (!parents.contains(parent)){
            parents.add(parent);
            return true;
        }
        return false;
    }

    public List<Person> getParents() {
        return parents;
    }

    public Person getFather() {
        for (Person parent: parents) {
            if (parent.getGender() == Gender.Male) {
                return father;
            }
        }
        return null;
    }

    public Person getMother() {
        for (Person parent: parents){
            if (parent.getGender() == Gender.Female) {
                return mother;
            }
        }
        return null;
    }

    public int getAge(){
        if (deathDate == null){
            return getPeriod(birthDate, LocalDate.now());
        } else {
            return getPeriod(birthDate, deathDate);
        }
    }

    private int getPeriod(LocalDate birthDate, LocalDate deathDate){
        Period diff = Period.between(birthDate, deathDate);
        return diff.getYears();
    }

    public LocalDate getBirthDate() {
        return birthDate;
    }

    public LocalDate getDeathDate() {
        return deathDate;
    }

    public void setBirthDate(LocalDate birthDate) {
        this.birthDate = birthDate;
    }

    public void setDeathDate(LocalDate deathDate) {
        this.deathDate = deathDate;
    }
    public void setSpouse(Person spouse) {
        this.spouse = spouse;
    }

    public Person getSpouse() {
        return spouse;
    }

    public String getName() {
        return name;
    }

   public Gender getGender() {
        return gender;
    }


    @Override
    public String toString(String getInfo) {
        return getInfo;
    }

    public String getInfo(){
        StringBuilder sb = new StringBuilder();
        sb.append(", имя: ");
        sb.append(name);
        sb.append(", пол: ");
        sb.append(getGender());
        sb.append(", возраст: ");
        sb.append(getAge());
        sb.append(", ");
        sb.append(getSpouseInfo());
        sb.append(", ");
        sb.append(getMotherInfo());
        sb.append(", ");
        sb.append(getFatherInfo());
        sb.append(", ");
        sb.append(getKidsInfo());
        return sb.toString();
    }
    public String getSpouseInfo(){
        String res = "супруг(а): ";
        if (spouse == null){
            res += "нет";
        } else {
            res += spouse.getName();
        }
        return res;
    }

    public String getMotherInfo(){
        String res = "мать: ";
        Person mother = getMother();
        if (mother != null){
            res += mother.getName();
        } else {
            res += "неизвестна";
        }
        return res;
    }

    public String getFatherInfo(){
        String res = "отец: ";
        Person father = getFather();
        if (father != null){
            res += father.getName();
        } else {
            res += "неизвестен";
        }
        return res;
    }

    public String getKidsInfo(){
        StringBuilder res = new StringBuilder();
        res.append("дети: ");
        if (kids.size() != 0){
            res.append(kids.get(0).getName());
            for (int i = 1; i < kids.size(); i++) {
                res.append(", ");
                res.append(kids.get(i).getName());
            }
        } else {
            res.append("отсутствуют");
        }
        return res.toString();
    }
}


