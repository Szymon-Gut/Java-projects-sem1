package com.company.Budynek;

import com.company.Osoby.CzlowiekZZewnatrz;
import com.company.Osoby.Student;
import com.company.Osoby.Studentka;
import com.company.Osoby.Uczestnik;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class Hol {
    public List<Uczestnik> uczestnicyWHolu;

    public Hol() {
        this.uczestnicyWHolu = new LinkedList<>();
        for (int i = 0; i < 33; i++) {
            uczestnicyWHolu.add(new Student());
        }
        for (int i = 0; i < 33; i++) {
            uczestnicyWHolu.add(new Studentka());
        }
        for (int i = 0; i < 33; i++) {
            uczestnicyWHolu.add(new CzlowiekZZewnatrz());
        }
    }


}
