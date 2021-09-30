package com.company.Ryby;

import com.company.Plansza;

public class RekinPolarny extends Ryba {
    protected int wiek;
    protected Plansza plansza;


    public RekinPolarny(int[] pozycja, Plansza plansza) {
        super(pozycja, plansza);
        this.wiek = random.nextInt(101) + 300;
        this.waga = random.nextInt(1001) + 500;
        this.plansza = plansza;

    }

    public RekinPolarny() {
        super();
        this.wiek = random.nextInt(101) + 300;
        this.waga = random.nextInt(1001) + 500;
        this.plansza = new Plansza();

    }

    public RekinPolarny(Ryba ryba) {
        super(ryba);
        this.waga = random.nextInt(1001) + 500;
        this.wiek = random.nextInt(101) + 300;
        this.plansza = ryba.plansza;
    }

    @Override
    public String toString() {
        return "RekinPolarny";
    }
}
