package People;

import java.io.Serializable;
import java.util.Objects;


public class Name implements Serializable {
    private String firstName;
    private String secondName;

    public Name(String firstName, String secondName) {
        this.firstName = firstName;
        this.secondName = secondName;
    }

    @Override
    public String toString() {
        return
                "firstName='" + firstName + '\'' +
                ", secondName='" + secondName;

    }

    public String getFirstName() {
        return firstName;
    }

    public String getSecondName() {
        return secondName;
    }


    public int compare(Name name) {
        if(this.getFirstName().compareTo(name.getFirstName()) == 0) {
            return this.getSecondName().compareTo(name.getSecondName());
        } else {
            return this.getFirstName().compareTo(name.getFirstName());
        }
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Name name = (Name) o;
        return Objects.equals(firstName, name.firstName) && Objects.equals(secondName, name.secondName);
    }

    @Override
    public int hashCode() {
        return Objects.hash(firstName, secondName);
    }
}
