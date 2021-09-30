package statki;

import gra.Plansza;

import java.util.Random;

public class Niszczyciel extends  Statki{
    Random random = new Random();
    protected String nazwa;
    protected int idNiszczyciel;
    protected int liczbaRakiet;
    protected int wytrzymalosc;
    protected Plansza plansza;
    private static int liczbaNiszczycieli = 0;

    public Niszczyciel() {
        super();
        this.nazwa = "Niszczyciel" + idNiszczyciel;
        this.idNiszczyciel = ++liczbaNiszczycieli;
        this.liczbaRakiet = random.nextInt(20) + 1;
        this.wytrzymalosc = 5;

    }

    public Niszczyciel(Niszczyciel niszczyciel) {
        super(niszczyciel);
        this.liczbaRakiet = niszczyciel.liczbaRakiet;
        this.idNiszczyciel = ++liczbaNiszczycieli;
        this.nazwa = niszczyciel.nazwa;
        this.plansza = niszczyciel.plansza;
    }
    public Niszczyciel (int[] polozenie, Plansza plansza) {
        super(polozenie, plansza,5);
        this.liczbaRakiet = random.nextInt(20) + 1;
        this.idNiszczyciel = ++liczbaNiszczycieli;
        this.wytrzymalosc = 5;
        this.nazwa = "Niszczyciel" + idNiszczyciel;
        this.plansza = plansza;
    }
    @Override
    public String toString() {
        return "Niszczyciel_id_" + id + "_unid " + idNiszczyciel;
    }
}
