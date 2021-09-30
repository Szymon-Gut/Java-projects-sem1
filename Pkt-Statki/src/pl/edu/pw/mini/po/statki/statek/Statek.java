package pl.edu.pw.mini.po.statki.statek;

import pl.edu.pw.mini.po.statki.Plansza;

import java.util.Random;

public abstract class Statek {
    protected String nazwa;
    protected int id;
    protected int wytrzymalosc;
    protected int[] polozenie;
    protected int trafienia;
    protected Plansza plansza;
    protected static int counter = 0;

    public Statek(int[] polozenie, Plansza plansza) {
        this.polozenie = polozenie;
        this.trafienia = 0;
        this.id = ++counter;
        this.plansza = plansza;
    }

    public Statek() { //potrzebny konstruktor (??)
        Random random = new Random();
        this.nazwa = "statek";
        this.id = ++counter;
        this.polozenie = new int[]{random.ints(0, 100).findFirst().getAsInt(),
                random.ints(0, 100).findFirst().getAsInt()};
//        this.wytrzymalosc = 69;
//        this.trafienia = 0;
        this.plansza = new Plansza();
    }

    public Statek(Statek statek, Plansza plansza) {
        this.nazwa = statek.nazwa;
        this.id = statek.id;
//        this.id = ++counter;
        this.wytrzymalosc = statek.wytrzymalosc;
        this.polozenie = statek.polozenie;
        this.trafienia = statek.trafienia;
        this.plansza = statek.plansza;
    }

}