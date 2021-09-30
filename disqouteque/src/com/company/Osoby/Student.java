package com.company.Osoby;

import com.company.Budynek.visitor.UczestnikVIsitor;

import java.util.List;
import java.util.Random;

public class Student extends Studenci {

    public Student() {
        super(imionaGenerujImiona());
    }

    public static String imionaGenerujImiona() {
        List<String> imiona = List.of("Szymon", "Michal", "Mikolaj", "Hubert", "Kacper", "Kuba", "Piotrek", "Tomek", "Bartek", "Krzysiek");
        Random random = new Random();
        return imiona.get(random.nextInt(10));
    }

    @Override
    public void apply(UczestnikVIsitor vIsitor) {
        vIsitor.visitStudent(this);
    }
}
