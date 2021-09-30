package gra;

import statki.Statki;

public class Plansza{
    public Statki[][] array;
    public Plansza() {
        this.array = new Statki[100][100];
    }
    public void wyswietl() {
        for (int i = 0; i < 100; i++) {
            for (int j = 0; j < 100; j++) {
                System.out.print(array[i][j] + " ");
            }
            System.out.println("");
        }
    }
    public void wstawStatek(Statki statek, int[] polozenie) {
        array[polozenie[0]][polozenie[1]] = statek;

    }
    public boolean sprawdzCzyWolne(int[] polozenie) {
        return array[polozenie[0]][polozenie[1]] == null;
    }
}
