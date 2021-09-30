package com.company.Ryby;

import com.company.Plansza;

import java.util.Random;

public abstract class JendostkiPlywajace {
    protected int[] polozenie;
    protected Plansza plansza;
    protected Random random = new Random();

    public JendostkiPlywajace() {
        int x = random.nextInt(101);
        int y = random.nextInt(101);
        this.polozenie = new int []{x,y};
    }

    public JendostkiPlywajace(int[] polozenie, Plansza plansza) {
        this.polozenie = polozenie;
        this.plansza = plansza;
    }
    public JendostkiPlywajace(JendostkiPlywajace jendostkiPlywajace) {
        this.polozenie = jendostkiPlywajace.polozenie;
        this.plansza = jendostkiPlywajace.plansza;
    }

    public int[] getPolozenie() {
        return polozenie;
    }

    public void setPolozenie(int[] polozenie) {
        this.polozenie = polozenie;
    }

    public Plansza getPlansza() {
        return plansza;
    }
}
