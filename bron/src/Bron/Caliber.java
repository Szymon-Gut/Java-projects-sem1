package Bron;

import java.io.Serializable;
import java.util.Objects;

public class Caliber implements Comparable <Caliber>, Serializable {
    private String value;
    private String additionalValue;

    public Caliber(String value, String additionalValue) {
        this.value = value;
        this.additionalValue = additionalValue;
    }

    @Override
    public String toString() {
        return "Caliber{" +
                "value='" + value + '\'' +
                ", additionalValue='" + additionalValue + '\'' +
                '}';
    }

    @Override
    public int compareTo(Caliber o) {
        if ((this.value.equals(o.value)) && (this.additionalValue.equals(o.additionalValue))) {
            return 0;
        } else {
            return -1;
        }
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Caliber caliber = (Caliber) o;
        return value.equals(caliber.value) && additionalValue.equals(caliber.additionalValue);
    }

    @Override
    public int hashCode() {
        return Objects.hash(value, additionalValue);
    }
}
