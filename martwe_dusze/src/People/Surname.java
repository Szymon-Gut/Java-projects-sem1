package People;

import java.io.Serializable;
import java.util.Objects;

public class Surname implements Serializable {
    private String surname;
    private double surnamePopularity;

    public Surname(String surname, double surnamePopularity) {
        this.surname = surname;
        this.surnamePopularity = surnamePopularity;
    }

    @Override
    public String toString() {
        return
                "surname='" + surname + '\'' +
                ", surnamePopularity=" + surnamePopularity;

    }

    public String getSurname() {
        return surname;
    }

    public double getSurnamePopularity() {
        return surnamePopularity;
    }

    public int compare(Surname surname) {
        return this.getSurname().compareTo(surname.getSurname());
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Surname surname1 = (Surname) o;
        return Double.compare(surname1.surnamePopularity, surnamePopularity) == 0 && Objects.equals(surname, surname1.surname);
    }

    @Override
    public int hashCode() {
        return Objects.hash(surname, surnamePopularity);
    }
}
