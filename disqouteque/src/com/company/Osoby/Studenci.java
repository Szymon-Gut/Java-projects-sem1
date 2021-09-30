package com.company.Osoby;

import java.util.List;
import java.util.Random;

public abstract class Studenci extends Uczestnik{
    private String nazwisko;
    public Studenci(String imie, int wiek) {
        super(imie, wiek);
        this.nazwisko = generujNazwisko();
    }

    public Studenci(String imie) {
        super(imie,generujWiek());
    }
    public static int generujWiek() {
        return new Random().nextInt(9)+18;
    }
    public String generujNazwisko() {
        List<String> nazwiska = List.of("Gut", "Git", "Good", "Besser", "Better", "Zyla", "Stoch", "Lewy", "Prawy", "Srodkowy");
        return nazwiska.get(new Random().nextInt(10));
    }

}
