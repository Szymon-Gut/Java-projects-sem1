package statki;

import gra.Plansza;

public abstract class Statki {
    protected String nazwa;
    protected int id;
    protected int wytrzymalosc;
    protected int liczbaTrafien;
    protected int[] polozenie;
    private static int liczbaOkretow = 0;
    private Plansza plansza;


    public Statki(int[] polozenie, Plansza plansza,int wytrzymalosc) {
        this.id = liczbaOkretow++;
        this.liczbaTrafien = 0;
        this.polozenie = polozenie;
        this.plansza = plansza;
        this.wytrzymalosc = wytrzymalosc;
    }


    public Statki(Statki statki) {
        this.nazwa = statki.nazwa;
        this.id = statki.id;
        this.wytrzymalosc = statki.wytrzymalosc;
        this.liczbaTrafien = statki.liczbaTrafien;
        this.polozenie = statki.polozenie;
        this.plansza = statki.plansza;

    }
    public Statki() {
        this.nazwa = "Statek" + id;
        this.id = liczbaOkretow++;
        this.wytrzymalosc = 0;
        this.liczbaTrafien = 0;
        this.polozenie = new int[] {0,0};
        this.plansza = new Plansza();
    }
    public void ostrzal(int[] strzal) {
        this.liczbaTrafien++;
        if (this.liczbaTrafien == this.wytrzymalosc) {
            System.out.println("Okret" + this + " zostal trafiony i ZATOPIONY");
            plansza.array[strzal[0]][strzal[1]] = null;
        } else {
            System.out.println("Okret " + this + " zostal trafiony");

        }

    }
}
