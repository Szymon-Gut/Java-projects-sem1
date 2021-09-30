package gra;


public class Gra implements  Rozgrywka{
    public Plansza plansza = new Plansza();
    int liczbaNiszczycieli;
    int liczbaFregat;
    int liczbaKorwet;
    public Gra()  {
        this.liczbaNiszczycieli = 100;
        this.liczbaFregat = 500;
        this.liczbaKorwet = 1000;
        inicjalizuj(liczbaNiszczycieli,liczbaFregat,liczbaKorwet);
    }
    public Gra(int liczbaNiszczycieli, int liczbaFregat, int liczbaKorwet) {
        this.liczbaKorwet = liczbaKorwet;
        this.liczbaFregat = liczbaFregat;
        this.liczbaNiszczycieli = liczbaNiszczycieli;
        inicjalizuj(liczbaNiszczycieli,liczbaFregat,liczbaKorwet);
    }
    public void inicjalizuj(int liczbaNiszczycieli, int liczbaFregat, int liczbaKorwet) {
        GeneratorStatkow generatorStatkow = new GeneratorStatkow(plansza);
        generatorStatkow.wygeneruj(liczbaNiszczycieli, liczbaFregat, liczbaKorwet);
        plansza.wyswietl();
        }
    Dzialo dzialo = new Dzialo();
    @Override
    public void graj(int liczbaTur) {

        for (int i = 0; i < liczbaTur; i++) {
            System.out.println("Tura nr." + (i + 1));
            for (int j = 0; j < 10; j++) {
                dzialo.ostrzal(plansza);
            }
            System.out.println("");
        }
    }
}
