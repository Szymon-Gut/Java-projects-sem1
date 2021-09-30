package pl.edu.pw.mini.po.statki;

import pl.edu.pw.mini.po.statki.statek.Statek;

public class Plansza {
    Statek[][] array;

    public Plansza() {
        this.array = new Statek[100][100];
    }

    public void wyswietl() {
        for (int i = 0; i < 100; i++) {
            for (int j = 0; j < 100; j++) {
                System.out.print(array[i][j] + " ");
            }
            System.out.println();
        }
    }

    public void wstaw_statek(Statek statek, int[] polozenie) {
        array[polozenie[0]][polozenie[1]] = statek;
    }

    public boolean sprawdz_pole_czy_wolne(int[] polozenie) {
        return array[polozenie[0]][polozenie[1]] == null;   //null bo tak
    }
}
