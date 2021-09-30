package Roboty;

import Roboty.enumy.Nazwa;
import Roboty.enumy.Zadanie;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;

public final class RobotProdukcja extends RobotFabryczny {

    public RobotProdukcja(LocalDate localDate, Nazwa nazwa, int identyfikator, SztucznaIntelignecja sztucznaIntelignecja, Zadanie zadanie) {
        super(localDate, nazwa, identyfikator, sztucznaIntelignecja, zadanie);
    }

    public RobotProdukcja(Zadanie zadanie) {
        super(zadanie);
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
