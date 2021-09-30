package statki;

import gra.Plansza;

import java.util.Random;

public class Fregata extends Statki{
    Random random = new Random();
    protected String nazwa;
    protected int idFregata;
    protected int liczbaDzial;
    protected int wytrzymalosc;
    protected Plansza plansza;
    private static int liczbaFregat = 0;

    public Fregata() {
        super();
        this.idFregata = ++liczbaFregat;
        this.nazwa = "Fregata" + idFregata;
        this.liczbaDzial= random.nextInt(6) + 1;
        this.wytrzymalosc = 3;
    }
    public Fregata(Fregata fregata) {
        super(fregata);
        this.idFregata = fregata.idFregata;
        this.liczbaDzial = fregata.liczbaDzial;
        this.wytrzymalosc = fregata.wytrzymalosc;
        this.nazwa = fregata.nazwa;
    }
    public Fregata(int[] polozenie, Plansza plansza) {
        super(polozenie, plansza, 3);
        this.liczbaDzial= random.nextInt(6) + 1;
        this.idFregata = ++liczbaFregat;
        this.nazwa = "Fregata" + idFregata;
        this.plansza = plansza;

    }

    @Override
    public String toString() {
        return "Fregata_id_" + id + "_unid " + idFregata;
    }
}
