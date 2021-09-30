package Roboty;

import Roboty.enumy.Nazwa;
import Roboty.enumy.Zadanie;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.Random;

public abstract class RobotFabryczny extends Robot{
    protected Zadanie zadanie;


    public RobotFabryczny(LocalDate localDate, Nazwa nazwa, int identyfikator, SztucznaIntelignecja sztucznaIntelignecja, Zadanie zadanie) {
        super(localDate, nazwa, identyfikator, sztucznaIntelignecja);
        this.zadanie = zadanie;
    }

    public RobotFabryczny(Zadanie zadanie) {
        super();
        this.zadanie = zadanie;
    }

    @Override
    public String toString() {
        return "Jestem robotem o imieniu " + nazwa + " z identyfikatorem " + identyfikator + " ilosc moich zadan do wykonania"
                + " to " + ileZadan + " aktualne zadanie to " + zadanie +
                "Moja reprezentacja danych w moim systemie jest " + sztucznaIntelignecja;
    }
    public void zadanieWykonaj() {
        ileZadan += random.nextInt(20) + 1;
    }
    @Override
    public void meldunek() {
        long days = ChronoUnit.DAYS.between(LocalDate.now(), localDate);
        System.out.println("Zyje juz " + days + " lat.");
    }
}
