package Bron;

import java.io.Serializable;
import java.util.Objects;

public class Weapon implements Serializable {
    private String name;
    private Caliber caliber;
    private int serialNumber;
    private double unfit;
    private boolean hasFingerprints;

    public Weapon(String name, Caliber caliber, int serialNumber, double unfit, boolean hasFingerprints) {
        this.name = name;
        this.caliber = caliber;
        this.serialNumber = serialNumber;
        this.unfit = unfit;
        this.hasFingerprints = hasFingerprints;
    }

    public Weapon(String name, Caliber caliber, double unfit, boolean hasFingerprints) {
        this.name = name;
        this.caliber = caliber;
        this.unfit = unfit;
        this.hasFingerprints = hasFingerprints;
    }

    @Override
    public String toString() {
        return "Weapon{" +
                "name='" + name + '\'' +
                ", caliber=" + caliber +
                ", serialNumber=" + serialNumber +
                ", unfit=" + unfit +
                ", hasFingerprints=" + hasFingerprints +
                '}';
    }

    public Caliber getCaliber() {
        return caliber;
    }


}
