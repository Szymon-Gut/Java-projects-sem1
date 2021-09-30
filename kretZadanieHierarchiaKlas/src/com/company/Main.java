package com.company;

import ObiektyZiemne.Environment;

public class Main {

    public static void main(String[] args) {
	Environment plansza = new Environment(10,10);
	plansza.inicjalizuj(5,4);
	plansza.runMole();
    }

}
