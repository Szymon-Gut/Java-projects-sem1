package com.company.Ryby;

import com.company.Plansza;
import com.company.Statki.Statek;

import java.util.Random;

public class Ryba extends JendostkiPlywajace{
    protected int waga;
    protected int[] pozycja;
    protected Plansza plansza;
    protected static Random random = new Random();

    public Ryba(int[] pozycja, Plansza plansza) {
        super(pozycja, plansza);
        this.plansza = plansza;

    }
    public Ryba() {
        super();
        this.plansza = new Plansza();
    }

    public Ryba(Ryba ryba) {
        this.pozycja = ryba.pozycja;
        this.plansza = ryba.plansza;
    }

    public void setPozycja(int[] pozycja) {
        this.pozycja = pozycja;
    }

    public int getWaga() {
        return waga;
    }

    public int[] getPozycja() {
        return pozycja;
    }

    public void move(Ryba ryba, Plansza plansza) {
        Random random = new Random();
        boolean goraDol = random.nextBoolean();
        boolean lewoPrawo = random.nextBoolean();
        int x = lewoPrawo ? 1 : -1;
        int y  = goraDol ? 1 : -1;
        int[] koordynaty = new int[2];


        if ((ryba.pozycja[0] + x) < 100 && (ryba.pozycja[0] + x) >= 0) {
            koordynaty[0] = pozycja[0] + x;
        } else {
            koordynaty[0] = pozycja[0] - x;
        }
        if ((ryba.pozycja[1] + y) < 100 && (ryba.pozycja[1] + y) >= 0) {
            koordynaty[1] = pozycja[1] + y;
        } else {
            koordynaty[1] = pozycja[1] - y;
        }
        if (plansza.sprawdzCzyWolne(koordynaty)) {
            plansza.plansza[koordynaty[0]][koordynaty[1]] = ryba;
            plansza.plansza[ryba.pozycja[0]][ryba.pozycja[1]] = null;
            ryba.setPozycja(koordynaty);
        }
    }
}
