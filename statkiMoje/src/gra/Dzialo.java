package gra;

import java.util.Random;

public class Dzialo {
    protected int[] strzal = new int[2];


    public void ostrzal(Plansza plansza) {
        Random random = new Random();
        int x = random.nextInt(100);
        int y = random.nextInt(100);
        int[] strzal = new int[]{x, y};
        if (!plansza.sprawdzCzyWolne(strzal)) {
            plansza.array[x][y].ostrzal(strzal);
        }
    }
}
