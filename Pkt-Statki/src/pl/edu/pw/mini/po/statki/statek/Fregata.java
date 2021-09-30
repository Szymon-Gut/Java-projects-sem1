package pl.edu.pw.mini.po.statki.statek;

import pl.edu.pw.mini.po.statki.Plansza;

import java.util.Random;

public class Fregata extends Statek {
    private int fregata_id;
    private int l_dzial;
    private static int counter;

    public Fregata(int[] polozenie, Plansza plansza) {
        super(polozenie, plansza);
        Random random = new Random();
        this.fregata_id = ++counter;
        this.nazwa = "Fregata_" + String.valueOf(fregata_id);
        this.l_dzial = random.ints(1, 6).findFirst().getAsInt();
        this.wytrzymalosc = 3;
    }

    public Fregata() {
        super();
        Random random = new Random();
        this.nazwa = "statek fregata";
        this.fregata_id = ++counter;
        this.l_dzial = random.ints(1, 6).findFirst().getAsInt();
        this.wytrzymalosc = 3;
    }

    public Fregata(Fregata statek, Plansza plansza) {
        super(statek, plansza);
        this.fregata_id = statek.fregata_id;
//        this.fregata_id = ++counter;
        this.l_dzial = statek.l_dzial;
        this.wytrzymalosc = statek.wytrzymalosc;
    }

    @Override
    public String toString() {
        return "Fregata" + this.id + "_" + fregata_id;
    }
}
