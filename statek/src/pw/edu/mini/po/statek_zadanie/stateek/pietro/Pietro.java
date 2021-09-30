package pw.edu.mini.po.statek_zadanie.stateek.pietro;

import java.util.Random;

public class Pietro {
    protected  Kajuta[] kajuty = new Kajuta[10];
    public int iloscPasazerow;

    public Pietro() {
        Random rand = new Random();
        int[] miejsca = {2,4};
        int ilosc = miejsca[rand.nextInt(2)];
        for (int i = 0; i < 10; i++) {
            kajuty[i] = new Kajuta(ilosc);
        }
    }

    public Kajuta[] getKajuty() {
        return kajuty;
    }
}
