package com.company.Statki;

import com.company.Plansza;
import com.company.Ryby.JendostkiPlywajace;
import com.company.Ryby.Ryba;

import java.util.Random;

public class Statek extends JendostkiPlywajace {
    protected String kod;
    protected int unikalnyKod;
    protected int maksymalnaLadownosc;
    protected int[] poczatkowaPozycja;
    protected int masaZlowionychRyb;
    protected Plansza plansza;
    protected static Random random = new Random();



    public Statek(int maksymalnaLadownosc, int[] poczatkowaPozycja, Plansza plansza) {
        super(poczatkowaPozycja,plansza);
        this.unikalnyKod = 1;
        this.maksymalnaLadownosc = maksymalnaLadownosc;
        this.poczatkowaPozycja = poczatkowaPozycja;
        this.masaZlowionychRyb = 0;
        this.kod = randomNumber();

    }

    public Statek() {
        super();
        this.unikalnyKod = 12345;
        this.kod = randomNumber();
        this.maksymalnaLadownosc = 5000;
        this.masaZlowionychRyb = 0;
        this.plansza = new Plansza();
    }


    public Statek(Statek statek) {
        this.unikalnyKod = statek.unikalnyKod;
        this.maksymalnaLadownosc = statek.maksymalnaLadownosc;
        this.poczatkowaPozycja = statek.poczatkowaPozycja;
        this.masaZlowionychRyb = statek.masaZlowionychRyb;
        this.kod = statek.kod;
        this.plansza = statek.plansza;
    }

    public void setKod(String kod) {
        this.kod = kod;
    }

    public void setUnikalnyKod(int unikalnyKod) {
        this.unikalnyKod = unikalnyKod;
    }

    public void setMaksymalnaLadownosc(int maksymalnaLadownosc) {
        this.maksymalnaLadownosc = maksymalnaLadownosc;
    }

    public void setPoczatkowaPozycja(int[] poczatkowaPozycja) {
        this.poczatkowaPozycja = poczatkowaPozycja;
    }

    public void setMasaZlowionychRyb(int masaZlowionychRyb) {
        this.masaZlowionychRyb = masaZlowionychRyb;
    }

    public void setPlansza(Plansza plansza) {
        this.plansza = plansza;
    }

    public String getKod() {
        return kod;
    }

    public int getUnikalnyKod() {
        return unikalnyKod;
    }

    public int getMaksymalnaLadownosc() {
        return maksymalnaLadownosc;
    }

    public int[] getPoczatkowaPozycja() {
        return poczatkowaPozycja;
    }

    public int getMasaZlowionychRyb() {
        return masaZlowionychRyb;
    }

    @Override
    public Plansza getPlansza() {
        return plansza;
    }

    protected static String randomNumber() {
        long number = random.nextLong();
        return String.valueOf((long)Math.sqrt(number));
    }

    public void move(Statek statek,Plansza plansza) {
        boolean goraDol = random.nextBoolean();
        boolean lewoPrawo = random.nextBoolean();
        int x = lewoPrawo ? 1 : -1;
        int y  = goraDol ? 1 : -1;
        int[] koordynaty = new int[2];
        if ((poczatkowaPozycja[0] + x) < 100 && (statek.poczatkowaPozycja[0] + x) >= 0) {
            koordynaty[0] = poczatkowaPozycja[0] + x;
        } else {
            koordynaty[0] = poczatkowaPozycja[0] - x;
        }


        if ((poczatkowaPozycja[1] + y) < 100 && (statek.poczatkowaPozycja[1] + y) >= 0) {
            koordynaty[1] = poczatkowaPozycja[1] + y;
        } else {
            koordynaty[1] = poczatkowaPozycja[1] - y;
        }


        if (plansza.sprawdzCzyWolne(koordynaty)) {
            plansza.plansza[koordynaty[0]][koordynaty[1]] = statek;
            plansza.plansza[statek.poczatkowaPozycja[0]][statek.poczatkowaPozycja[1]] = null;
            statek.setPoczatkowaPozycja(koordynaty);
        } else {


            if (plansza.plansza[koordynaty[0]][koordynaty[1]] instanceof Ryba) {

                 if (statek.masaZlowionychRyb + ((Ryba)plansza.plansza[koordynaty[0]][koordynaty[1]]).getWaga() >= statek.maksymalnaLadownosc) {
                     System.out.println("Statek jest przeladowany i nie prowadzi juz polowow");
                     statek.setPoczatkowaPozycja(null);
                     plansza.plansza[koordynaty[0]][koordynaty[1]] = null;

                 } else {
                     statek.setMasaZlowionychRyb(((Ryba)plansza.plansza[koordynaty[0]][koordynaty[1]]).getWaga());
                 }


            }
        }
    }
}
