package pl.edu.pw.mini.po.statki.statek;

import pl.edu.pw.mini.po.statki.Plansza;

import java.util.Random;

public class Korweta extends Statek {
    private int korweta_id;
    private int l_bomb;
    private static int counter = 0;

    public Korweta(int[] polozenie, Plansza plansza) {
        super(polozenie, plansza);
        Random random = new Random();
        this.korweta_id = ++counter;
        this.nazwa = "Korweta_" + String.valueOf(korweta_id);
        this.l_bomb = random.ints(1, 4).findFirst().getAsInt();
        this.wytrzymalosc = 1;
    }

    public Korweta() {
        super();
        Random random = new Random();
        this.korweta_id = ++counter;
        this.l_bomb = random.ints(1, 4).findFirst().getAsInt();
        this.wytrzymalosc = 1;
    }

    public Korweta(Korweta statek, Plansza plansza) {
        super(statek, plansza);
        this.korweta_id = statek.korweta_id;
        this.korweta_id = ++counter;
        this.l_bomb = statek.l_bomb;
        this.wytrzymalosc = statek.wytrzymalosc;
    }

    @Override
    public String toString() {
        return "Korweta" + this.id + "_" + korweta_id;
    }
}
