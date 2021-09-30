package People;

import java.io.Serializable;
import java.util.Objects;


public class Person implements  Serializable {
    private Name name;
    private Surname surname;
    private String sex;
    private int age;

    public Person(Name name, Surname surname, String sex, int age) {
        this.name = name;
        this.surname = surname;
        this.sex = sex;
        this.age = age;
    }

    @Override
    public String toString() {
        return "People.Person{" +
                "name=" + name +
                ", surname=" + surname +
                ", sex='" + sex + '\'' +
                ", age=" + age +
                '}';
    }

    public Name getName() {
        return name;
    }

    public Surname getSurname() {
        return surname;
    }

    public String getSex() {
        return sex;
    }

    public int getAge() {
        return age;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Person person = (Person) o;
        return age == person.age && name.equals(person.name) && surname.equals(person.surname) && sex.equals(person.sex);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, surname, sex, age);
    }
}

