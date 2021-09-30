package com.company.Budynek;

import Exceptions.PrzepelnionaSalaException;
import com.company.Osoby.Uczestnik;

import java.util.ArrayList;
import java.util.List;

public class Sala {
    private int maksymalnaPojemnosc;
    private  List<Uczestnik> uczestnicy;

    public Sala(int maksymalnaPojemnosc) {
        this.maksymalnaPojemnosc = maksymalnaPojemnosc;
        this.uczestnicy = new ArrayList<>();
    }
    public void dodawajDoSali(Uczestnik uczestnik) throws PrzepelnionaSalaException {
        if(uczestnicy.size() < maksymalnaPojemnosc) {
            uczestnicy.add(uczestnik);
        } else {
            throw new PrzepelnionaSalaException();
        }
    }
}
