package com.company.Osoby;

import com.company.Budynek.visitor.UczestnikVIsitor;

import java.util.List;
import java.util.Random;

public class CzlowiekZZewnatrz extends Uczestnik {

    public CzlowiekZZewnatrz() {
        super(imionaGenerujImiona(), generujWiek());
    }

    public static int generujWiek() {
        return new Random().nextInt(25) + 16;
    }

    private static String imionaGenerujImiona() {
        List<String> imiona = List.of("Kasia", "Aneta", "Malwina", "Alicja", "Sabina", "Zaneta", "Ela", "Bogusia", "Renata",
                "Lucja", "Szymon", "Michal", "Mikolaj", "Hubert", "Kacper", "Kuba", "Piotrek", "Tomek", "Bartek", "Krzysiek");
        Random random = new Random();
        return imiona.get(random.nextInt(20));
    }

    @Override
    public void apply(UczestnikVIsitor vIsitor) {
        vIsitor.visitCzlowiekZZewnatrz(this);
    }
}
