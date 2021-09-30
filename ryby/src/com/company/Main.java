package com.company;

public class Main {

    public static void main(String[] args) {
        Plansza plansza = new Plansza();
	    Symulator symulator = new Symulator(plansza);
	    symulator.inicjalizuj(100,100,100,100);
	    plansza.wyswietl();


    }
}
