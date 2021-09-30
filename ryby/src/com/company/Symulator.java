package com.company;

import com.company.Ryby.RekinOstronosy;
import com.company.Ryby.RekinPolarny;
import com.company.Statki.Kuter;
import com.company.Statki.Trwaler;

import java.util.Random;

public class Symulator {
    private Plansza plansza;
    protected int liczbaTraweler;
    protected int liczbaKutrow;
    protected int liczbaRekinowPolarnych;
    protected int liczbaRekinowOstronosych;


    public Symulator(Plansza plansza,int liczbaRekinowPolarnych,int liczbaRekinowOstronosych,int liczbaKutrow, int liczbaTraweler) {
        this.plansza = plansza;
        this.liczbaKutrow = liczbaKutrow;
        this.liczbaTraweler = liczbaTraweler;
        this.liczbaRekinowOstronosych = liczbaRekinowOstronosych;
        this.liczbaRekinowPolarnych = liczbaRekinowPolarnych;
    }

    public Symulator(Plansza plansza) {
        this.plansza = plansza;
        this.liczbaTraweler = 100;
        this.liczbaKutrow = 100;
        this.liczbaRekinowPolarnych = 500;
        this.liczbaRekinowOstronosych = 500;
    }



    public void inicjalizuj(int liczbaTraweler, int liczbaKutrow, int liczbaRekinowPolarnych, int liczbaRekinowOstronosych) {
        for (int i = 0; i < liczbaTraweler; i++){
            int[] polozenie = losowePolozenie();
            while (!plansza.sprawdzCzyWolne(polozenie)) {
                polozenie = losowePolozenie();
            }
            Trwaler trwaler = new Trwaler(polozenie,plansza);
            plansza.wstawObiekt(trwaler,polozenie);
        }
        for (int i = 0; i < liczbaKutrow; i++){
            int[] polozenie = losowePolozenie();
            while (!plansza.sprawdzCzyWolne(polozenie)) {
                polozenie = losowePolozenie();
            }
            Kuter kuter = new Kuter(polozenie, plansza);
            plansza.wstawObiekt(kuter,polozenie);
        }
        for (int i = 0; i < liczbaRekinowOstronosych; i++){
            int[] polozenie = losowePolozenie();
            while (!plansza.sprawdzCzyWolne(polozenie)) {
                polozenie = losowePolozenie();
            }
            RekinOstronosy rekinOstronosy = new RekinOstronosy(polozenie,plansza);
            plansza.wstawObiekt(rekinOstronosy,polozenie);
        }
        for (int i = 0; i < liczbaRekinowPolarnych; i++){
            int[] polozenie = losowePolozenie();
            while (!plansza.sprawdzCzyWolne(polozenie)) {
                polozenie = losowePolozenie();
            }
            RekinPolarny rekinPolarny = new RekinPolarny(polozenie,plansza);
            plansza.wstawObiekt(rekinPolarny,polozenie);
        }
    }




    private int[] losowePolozenie() {
        Random random = new Random();
        int x = random.nextInt(100);
        int y = random.nextInt(100);
        return new int[] {x,y};
    }
}
