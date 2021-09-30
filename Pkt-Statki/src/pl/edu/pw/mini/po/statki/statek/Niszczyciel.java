package pl.edu.pw.mini.po.statki.statek;

import pl.edu.pw.mini.po.statki.Plansza;

import java.util.Random;

public class Niszczyciel extends Statek {
    private int niszczyciel_id;
    private int l_rakiet;
    private static int counter = 0;

    public Niszczyciel(int[] polozenie, Plansza plansza) {
        super(polozenie, plansza);
        Random random = new Random();
        this.niszczyciel_id = ++counter;
        this.nazwa = "Niszczyciel_" + String.valueOf(niszczyciel_id);
        this.l_rakiet = random.ints(0, 20).findFirst().getAsInt();
        this.wytrzymalosc = 5;
    }

    public Niszczyciel() {
        super();
        Random random = new Random();
        this.nazwa = "statek niszczyciel";
        this.niszczyciel_id = ++counter;
        this.l_rakiet = random.ints(0, 20).findFirst().getAsInt();
        this.wytrzymalosc = 5;
    }

    public Niszczyciel(Niszczyciel statek, Plansza plansza) {
        super(statek, plansza);
        this.niszczyciel_id = statek.niszczyciel_id;
//        this.niszczyciel_id = ++counter;
        this.l_rakiet = statek.l_rakiet;
        this.wytrzymalosc = statek.wytrzymalosc;
    }

    @Override
    public String toString() {
        return "Niszczyciel" + this.id + "_" + niszczyciel_id;
    }
}