package ObiektyZiemne;

import java.util.Random;

public class Larwa extends ObiektyZiemne{
    private float masa;
    private static Random random = new Random();


    public Larwa(int wartoscOdzywcza) {
        super(wartoscOdzywcza);
        this.masa = (float) (2.0 + random.nextFloat() * (3.0 - 2.0));
    }

    public Larwa() {
        super();
        this.masa = (float) (2.0 + random.nextFloat() * (3.0 - 2.0));
    }

    public float getMasa() {
        return masa;
    }

    public void setMasa(float masa) {
        this.masa = masa;
    }

    @Override
    public String toString() {
        return "L";
    }
}
