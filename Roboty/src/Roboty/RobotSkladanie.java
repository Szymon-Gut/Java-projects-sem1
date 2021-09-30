package Roboty;

import Roboty.enumy.Nazwa;
import Roboty.enumy.Zadanie;
import Roboty.interfejsy.PorozumieniePlus;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.Random;

public final class RobotSkladanie extends RobotFabryczny implements PorozumieniePlus {
    protected int limit;
    protected static Random random = new Random();


    public RobotSkladanie(LocalDate localDate, Nazwa nazwa, int identyfikator, int ileZadan, SztucznaIntelignecja sztucznaIntelignecja, Zadanie zadanie) {
        super(localDate, nazwa, identyfikator, sztucznaIntelignecja, zadanie);
        this.limit = random.nextInt(10) + 1;
    }

    public RobotSkladanie(Zadanie zadanie) {
        super(zadanie);
        this.limit = random.nextInt(10) + 1;
    }
    @Override
    public String toString() {
        return "Jestem robotem o imieniu " + nazwa + " z identyfikatorem " + identyfikator + " ilosc moich zadan do wykonania"
                + " to " + ileZadan + " aktualne zadanie to " + zadanie + "w trakcie jednego " +
                "cyklu producyjnego moge wykonac " + limit + " zadan. " +
                "Moja reprezentacja danych w moim systemie jest " + sztucznaIntelignecja;
    }
    public void zadanieWykonaj() {
        int dodane = random.nextInt(20) + 1;
        if (ileZadan + dodane > limit) {
            System.out.println("nie mozna dodac zadan wieej ");
        } else {
            ileZadan += dodane;
        }

    }
    @Override
    public void meldunek() {
        long days = ChronoUnit.DAYS.between(LocalDate.now(), localDate);
        System.out.println("Zyje juz " + days + " lat.");
    }

    @Override
    public void powitanie() {
        System.out.println(nazwa + " mowi witaj");
    }
}
