package ObiektyZiemne;

import java.util.Random;

public class Gleba extends ObiektyZiemne {
    private float gestosc;
    private static Random random = new Random();

    public Gleba(int wartoscOdzywcza) {
        super(wartoscOdzywcza);
        this.gestosc = random.nextFloat() + 1.4f;
    }

    public Gleba() {
        super();
        this.gestosc = random.nextFloat() + 1.4f;
    }

    public float getGestosc() {
        return gestosc;
    }

    public void setGestosc(float gestosc) {
        this.gestosc = gestosc;
    }

    @Override
    public String toString() {
        return "Z";
    }
}
