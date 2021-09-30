package com.company.Ryby;

import com.company.Plansza;

public class RekinOstronosy extends Ryba {


    public RekinOstronosy(int[] polozenie, Plansza plansza) {
        super(polozenie,plansza);
        this.waga = random.nextInt(201) + 200;
    }
    public RekinOstronosy() {
        super();
        this.waga = random.nextInt(201) + 200;
    }


    public RekinOstronosy(Ryba ryba, Plansza plansza) {
        super(ryba);
        this.waga = random.nextInt(201) + 200;
    }

    @Override
    public String toString() {
        return "RekinOstronosy";
    }
}
