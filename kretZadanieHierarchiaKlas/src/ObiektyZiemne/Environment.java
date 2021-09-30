package ObiektyZiemne;

import java.util.Random;

public class Environment {
    public static ObiektyZiemne [][] plansza;
    private static final int WARTOSC_ODZYWCZA_DZDZOWNICY = 3;
    private Random random = new Random();
    private MoleMotion moleMotion;


    public Environment(int m, int n) {
        this.plansza = new ObiektyZiemne[m][n];
        this.moleMotion = new Kret(Gatunek.europaea, this, losowePolozenie());
    }

    public void inicjalizuj(int iloscLarw, int iloscDzdzownic) {
        for (int i = 0; i < iloscDzdzownic; i++) {
            int [] wspolrzedne = losowePolozenie();
            while(!sprawdzCzyWolne(wspolrzedne)) {
                wspolrzedne = losowePolozenie();
            }
            Dzdzownica dzdzownica = new Dzdzownica(WARTOSC_ODZYWCZA_DZDZOWNICY);
            plansza[wspolrzedne[0]][wspolrzedne[1]] = dzdzownica;
        }
        for (int j = 0; j < iloscLarw; j++) {
            int [] wspolrzedne = losowePolozenie();
            while(!sprawdzCzyWolne(wspolrzedne)) {
                wspolrzedne = losowePolozenie();
            }
            Larwa larwa = new Larwa(random.nextInt(3) + 3);
            plansza[wspolrzedne[0]][wspolrzedne[1]] = larwa;
        }

        for (int k = 0; k < plansza.length; k++) {
            for (int s = 0; s < plansza[0].length; s++) {
                int[] cords = {k,s};
                if (sprawdzCzyWolne(cords)){
                    Gleba gleba = new Gleba(0);
                    plansza[cords[0]][cords[1]] = gleba;
                }
            }
        }
    }

    public void wyswietl() {
        for (int i = 0; i < plansza.length; i++) {
            for (int j = 0; j < plansza[0].length; j++){
                if (plansza[i][j] == null) {
                    System.out.print("  ");
                } else {
                    System.out.print(plansza[i][j] + " ");
                }
            }
            System.out.println("");
        }
    }

    public boolean sprawdzCzyWolne(int [] polozenie) {
        return plansza[polozenie[0]][polozenie[1]] == null;
    }

    public int[] losowePolozenie() {
        int x = random.nextInt(plansza[0].length);
        int y = random.nextInt(plansza.length);
        return new int [] {x,y};
    }

    public void runMole() {
        for (int i =0; i < 10; i++) {
            this.moleMotion.goMole();
            wyswietl();
        }
    }

    public ObiektyZiemne[][] getPlansza() {
        return plansza;
    }

    public void setPlansza(ObiektyZiemne[][] plansza) {
        this.plansza = plansza;
    }
    public void wstawObiekt(ObiektyZiemne obiektyZiemne, int[] polozenie) {
        plansza[polozenie[0]][polozenie[1]] = obiektyZiemne;
    }

}
