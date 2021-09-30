package ObiektyZiemne;

import java.util.Random;

public class Kret extends ObiektyZiemne implements MoleMotion{
    private Gatunek gatunek;
    private Environment environment;
    private static Random random = new Random();
    private int[] polozenie;

    public Kret(Gatunek gatunek, Environment environment,int[] polozenie) {
        super(random.nextInt(41) + 200);
        this.gatunek = gatunek;
        this.environment = environment;
        this.polozenie = polozenie;
    }

    public Kret() {
        super();
        this.gatunek = Gatunek.cinerea;
        this.environment = null;
    }



    @Override
    public void goMole() {
        this.polozenie = environment.losowePolozenie();
        if(!environment.sprawdzCzyWolne(polozenie)) {
            this.setWartoscOdzywcza(super.getWartoscOdzywcza() + environment.getPlansza()[polozenie[0]][polozenie[1]]
                    .getWartoscOdzywcza());

            System.out.println("Mniam, wartosc odzywcza: " + (environment.getPlansza()[polozenie[0]][polozenie[1]]
                    .getWartoscOdzywcza()) + " w miejscu  " + polozenie[0] + " " + polozenie[1]);
            environment.wstawObiekt(null, polozenie);

        } else {
            System.out.println("Pusto");
        }
    }



    @Override
    public String getNutritionalValue() {
        return String.valueOf(super.getWartoscOdzywcza());
    }

    public Gatunek getGatunek() {
        return gatunek;
    }

    public void setGatunek(Gatunek gatunek) {
        this.gatunek = gatunek;
    }

    public Environment getEnvironment() {
        return environment;
    }

    public void setEnvironment(Environment environment) {
        this.environment = environment;
    }
}
