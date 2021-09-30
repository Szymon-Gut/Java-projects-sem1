package pl.edu.pw.mini.po.statki;

import pl.edu.pw.mini.po.statki.statek.*;

public class Gra {
    public Plansza plansza;

    public Gra(Plansza plansza) {
        this.plansza = plansza;
        System.out.printf("Gra stworzona!");
    }

    public void inicjalizuj(int LiczbaNiszczycieli, int LiczbaFregat, int LiczbaKorwet) {
        GeneratorStatkow generatorStatkow = new GeneratorStatkow(plansza);
        generatorStatkow.generuj(LiczbaNiszczycieli, LiczbaFregat, LiczbaKorwet);
        plansza.wyswietl();
    }
}