package pw.edu.mini.po.statek_zadanie.stateek.pietro;

import pw.edu.mini.po.statek_zadanie.stateek.Pasazer;

public class Kajuta {
    protected Pasazer[] miejsca;

    public Kajuta(int iloscMiejsc) {
        this.miejsca = new Pasazer[iloscMiejsc];
    }

    public Pasazer[] getMiejsca() {
        return miejsca;
    }
}
