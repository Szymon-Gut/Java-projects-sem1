package com.company;

import com.company.Ryby.JendostkiPlywajace;

import java.util.Random;


public class Plansza {
    public JendostkiPlywajace [][] plansza;


    public Plansza() {
        this.plansza = new JendostkiPlywajace[100][100];
    }


    public void wyswietl() {
        for (int i = 0; i < 100; i++) {
            for (int j = 0; j < 100; j++) {
                System.out.print(plansza[i][j] + " ");
            }
            System.out.println("");
        }

    }
    public void wstawObiekt(JendostkiPlywajace jendostkiPlywajace, int [] polozenie) {
        plansza[polozenie[0]][polozenie[1]] = jendostkiPlywajace;
    }

    public void setPlansza(JendostkiPlywajace[][] plansza) {
        this.plansza = plansza;
    }

    public boolean sprawdzCzyWolne(int[] polozenie) {
        return (plansza[polozenie[0]][polozenie[1]] == null);
    }


}