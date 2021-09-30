package ObiektyZiemne;

import java.util.Random;

public class Dzdzownica extends ObiektyZiemne{
    private float masa;
    private static Random random = new Random();

    public Dzdzownica(int wartoscOdzywcza) {
        super(wartoscOdzywcza);
        this.masa = (float) (0.5 + random.nextFloat() * (1.0 - 0.5));
    }

    public Dzdzownica() {
        super();
        this.masa = (float) (0.5 + random.nextFloat() * (1.0 - 0.5));
    }

    public float getMasa() {
        return masa;
    }

    public void setMasa(float masa) {
        this.masa = masa;
    }

    @Override
    public String toString() {
        return "D";
    }
}
