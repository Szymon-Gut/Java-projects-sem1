package gra;

import statki.Fregata;
import statki.Korweta;
import statki.Niszczyciel;

import java.util.Random;

public class GeneratorStatkow {
    private Plansza plansza;
    public  GeneratorStatkow(Plansza plansza) {
        this.plansza = plansza;
    }
    public void wygeneruj(int liczbaNiszczycieli, int liczbaFregat, int liczbaKorwet) {
        for (int i = 0; i < liczbaFregat; i++) {
            int[] polozenie = losowePolozenie();
            while (!plansza.sprawdzCzyWolne(polozenie)){
                polozenie = losowePolozenie();
            }
            Fregata fregata = new Fregata(polozenie, plansza);
            plansza.wstawStatek(fregata,polozenie);
        }
        for (int i = 0; i < liczbaNiszczycieli; i++) {
            int[] polozenie = losowePolozenie();
            while (!plansza.sprawdzCzyWolne(polozenie)) {
                polozenie = losowePolozenie();
            }
            Niszczyciel niszczyciel = new Niszczyciel(polozenie, plansza);
            plansza.wstawStatek(niszczyciel,polozenie);

        }
        for (int i = 0; i < liczbaKorwet; i++) {
            int[] polozenie = losowePolozenie();
            while (!plansza.sprawdzCzyWolne(polozenie)) {
                polozenie = losowePolozenie();
            }
            Korweta korweta = new Korweta(polozenie, plansza);
            plansza.wstawStatek(korweta,polozenie);
        }
    }



    private  int[] losowePolozenie() {
        Random random = new Random();
        int x = random.nextInt(100);
        int y = random.nextInt(100);
        return new int[] {x,y};
    }

}
