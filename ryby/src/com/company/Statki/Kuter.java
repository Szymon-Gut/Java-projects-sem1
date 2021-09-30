package com.company.Statki;
import com.company.Plansza;
import com.company.Statki.Statek;

public class Kuter extends Statek {
    protected int maksymalnaLadownosc;
    protected  Plansza plansza;



    public Kuter(int[] poczatkowaPozycja, Plansza plansza) {
        super(5000, poczatkowaPozycja, plansza);
    }



    public Kuter(Statek statek, Plansza plansza) {
        super(statek);
        this.maksymalnaLadownosc = 5000;
        this.plansza = statek.plansza;
    }

    @Override
    public String toString() {
        return "Kuter";
    }
}
