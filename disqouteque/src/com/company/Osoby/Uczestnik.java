package com.company.Osoby;

import com.company.Budynek.visitor.UczestnikVIsitor;

import java.util.Objects;

public abstract class Uczestnik {
    private static final int COUNTER = 1;
    private int unikalneId;
    private String imie;
    private int wiek;

    public Uczestnik(String imie, int wiek) {
        this.imie = imie;
        this.wiek = wiek;
        this.unikalneId += COUNTER;
    }

    public abstract void apply(UczestnikVIsitor vIsitor);

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Uczestnik uczestnik = (Uczestnik) o;
        return unikalneId == uczestnik.unikalneId;
    }

    @Override
    public int hashCode() {
        return Objects.hash(unikalneId);
    }

    @Override
    public String toString() {
        return "Uczestnik{" +
                "imie='" + imie + '\'' +
                ", wiek=" + wiek +
                '}';
    }

    public int getWiek() {
        return wiek;
    }

    public String getImie() {
        return imie;
    }

}
