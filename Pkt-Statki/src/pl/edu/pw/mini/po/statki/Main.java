package pl.edu.pw.mini.po.statki;

public class Main {
    public static void main(String[] args) {
        Plansza plansza = new Plansza();
        Gra gra = new Gra(plansza);
        gra.inicjalizuj(1, 35, 16);
    }
}