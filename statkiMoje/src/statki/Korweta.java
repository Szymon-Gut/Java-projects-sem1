package statki;

import gra.Plansza;

import java.util.Random;

public class Korweta extends Statki {
    Random random = new Random();
    protected String nazwa;
    private static int liczbaKorwet = 0;
    protected int idKorweta;
    protected int bombyGlebinowe;
    protected int wytrzymalosc;
    protected Plansza plansza;


    public Korweta() {
        super();
        this.nazwa = "Korweta" + idKorweta;
        this.idKorweta = ++liczbaKorwet;
        this.bombyGlebinowe = random.nextInt(4) + 1;
        this.wytrzymalosc = 1;
    }
    public Korweta(Korweta korweta) {
        super(korweta);
        this.idKorweta = korweta.idKorweta;
        this.bombyGlebinowe = korweta.bombyGlebinowe;
        this.nazwa = korweta.nazwa;
        this.plansza = korweta.plansza;
        this.wytrzymalosc = korweta.wytrzymalosc;
    }
    public Korweta(int[] polozenie, Plansza plansza) {
        super(polozenie, plansza,1);
        this.bombyGlebinowe = random.nextInt(4) + 1;
        this.idKorweta = ++liczbaKorwet;
        this.nazwa = "Korweta" + idKorweta;
        this.wytrzymalosc = 1;
        this.plansza = plansza;

    }
    @Override
    public String toString() {
        return "Korweta_id_" + id + "_unid " + idKorweta;
    }
}
