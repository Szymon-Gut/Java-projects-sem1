package pl.edu.pw.mini.po.statki;

import pl.edu.pw.mini.po.statki.statek.Fregata;
import pl.edu.pw.mini.po.statki.statek.Korweta;
import pl.edu.pw.mini.po.statki.statek.Niszczyciel;

import java.util.Random;

public class GeneratorStatkow {
    private Plansza plansza;

    public GeneratorStatkow(Plansza plansza) {
        this.plansza = plansza;
    }

    public void generuj(int LiczbaNieszczycieli, int LiczbaFregat, int LiczbaKorwet) {
        for (int i = 0; i < LiczbaNieszczycieli; i++) {
            int[] polozenie = losowe_polozenie();
            while (!plansza.sprawdz_pole_czy_wolne(polozenie)) {
                polozenie = losowe_polozenie();
            }
            Niszczyciel niszczyciel = new Niszczyciel(polozenie, plansza);
            plansza.wstaw_statek(niszczyciel, polozenie);
        }

        for (int i = 0; i < LiczbaFregat; i++) {
            int[] polozenie = losowe_polozenie();
            while (!plansza.sprawdz_pole_czy_wolne(polozenie)) {
                polozenie = losowe_polozenie();
            }
            Fregata fregata = new Fregata(polozenie, plansza);
            plansza.wstaw_statek(fregata, polozenie);
        }

        for (int i = 0; i < LiczbaKorwet; i++) {
            int[] polozenie = losowe_polozenie();
            while (!plansza.sprawdz_pole_czy_wolne(polozenie)) {
                polozenie = losowe_polozenie();
            }
            Korweta korweta = new Korweta(polozenie, plansza);
            plansza.wstaw_statek(korweta, polozenie);
        }
    }


    private static int[] losowe_polozenie() {
        Random random = new Random();
        int x = random.ints(0, 100).findFirst().getAsInt();
        int y = random.ints(0, 100).findFirst().getAsInt();
        return new int[]{x, y};
    }
}
