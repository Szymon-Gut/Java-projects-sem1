package pw.edu.mini.po.statek_zadanie.wyjatki;

import pw.edu.mini.po.statek_zadanie.stateek.Pasazer;

public class brakNaLiscieException extends Throwable{
    protected Pasazer pasazerBezBiletu;

    public brakNaLiscieException(Pasazer pasazer) {
        System.out.println("Zatrzymujemy statek i  dodajemy do listy: " + pasazer);
        this.pasazerBezBiletu = pasazer;
    }

    public Pasazer getPasazerBezBiletu() {
        return pasazerBezBiletu;
    }
}
