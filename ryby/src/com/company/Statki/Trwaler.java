package com.company.Statki;

import com.company.Plansza;
import com.company.Statki.Statek;

import java.util.Random;

public class Trwaler extends Statek {
    protected int liczebnoscZalogi;
    protected Plansza plansza;
    protected Random random = new Random();



    public Trwaler(int[] poczatkowaPozycja, int liczebnoscZalogi, Plansza plansza) {
        super(50000, poczatkowaPozycja, plansza);
        this.liczebnoscZalogi = liczebnoscZalogi;
    }

    public Trwaler(int[] poczatkowaPozycja, Plansza plansza) {
        this.liczebnoscZalogi = random.nextInt(51);
        this.maksymalnaLadownosc = 50000;
        this.poczatkowaPozycja = poczatkowaPozycja;
        this.plansza = plansza;
    }

    public Trwaler(Statek statek, int liczebnoscZalogi) {
        super(statek);
        this.liczebnoscZalogi = liczebnoscZalogi;
        this.plansza = statek.plansza;
    }

    @Override
    public String toString() {
        return "Trwaler";
    }
}
