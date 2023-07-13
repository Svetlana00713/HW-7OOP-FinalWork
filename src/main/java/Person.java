import java.util.List;
import java.io.*;
public class Person implements Serializable{
    private String name;
    private Gender gender;
    private Person father;
    private Person mother;
    List<Person> kids;
    private int year;

    public Person(String name, Gender gender, int year, Person father, Person mother, List<Person> kids) {
        this.name = name;
        this.gender = gender;
        this.year = year;
        this.father = father;
        this.mother = mother;
        this.kids = kids;
    }

    public Person(String name, Gender gender, Person father, Person mother) {
        this.name = name;
        this.gender = gender;
        this.year = year;
        this.father = father;
        this.mother = mother;
    }
    public Person(String name, Gender gender, int year, List<Person> kids) {
        this.name = name;
        this.gender = gender;
        this.year = year;
        this.kids = kids;
    }
    public Person(String name, Gender gender) {
        this.name = name;
        this.gender = gender;
        this.year = year;
    }
    public String getName() {
        return name;
    }
    public Gender getGender() {
        return gender;
    }
    public Person dadOf() {
        return father;
    }
    public Person momOf() {
        return mother;
    }
    public String getFather() {
        return "father- " + father.toString();
    }
    public String getMother() {
        return "mother- " + mother.toString();
    }
    public String getKid() {
        return "kid: " + kids.toString();
    }
    public int getYear() {
        return year;
    }
    @Override
    public String toString() {
        String str;
        str = getName() + " (" + getYear() + ")";
        if (father != null)
            str += ": " + getFather() + ";";
        if (mother != null)
            str += " " + getMother();
        if (kids != null)
            str += " " + getKid();
        return str;
    }
}
