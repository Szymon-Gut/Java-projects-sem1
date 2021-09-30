package com.company.Osoby;

import com.company.Budynek.visitor.UczestnikVIsitor;

import java.util.List;
import java.util.Random;

public class Studentka extends Studenci {
    public Studentka() {
        super(imionaGenerujImiona());
    }

    private static String imionaGenerujImiona() {
        List<String> imiona = List.of("Kasia", "Aneta", "Malwina", "Alicja", "Sabina", "Zaneta", "Ela", "Bogusia", "Renata", "Lucja");
        Random random = new Random();
        return imiona.get(random.nextInt(10));
    }

    @Override
    public void apply(UczestnikVIsitor vIsitor) {
        vIsitor.visitStudentka(this);
    }
}
