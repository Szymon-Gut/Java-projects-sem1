package Roboty;

import Roboty.enumy.Nazwa;
import Roboty.interfejsy.PorozumieniePlus;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;

public class RobotDomowy extends Robot implements PorozumieniePlus {
    public RobotDomowy(LocalDate localDate, Nazwa nazwa, int identyfikator, SztucznaIntelignecja sztucznaIntelignecja) {
        super(localDate, nazwa, identyfikator, sztucznaIntelignecja);
    }
    public RobotDomowy() {
        super();
    }
    public RobotDomowy(RobotDomowy robotDomowy) {
        this.localDate = robotDomowy.localDate;
        this.nazwa = robotDomowy.nazwa;
        this.identyfikator = robotDomowy.identyfikator;
        this.ileZadan = robotDomowy.ileZadan;
        this.sztucznaIntelignecja = robotDomowy.sztucznaIntelignecja;
    }
    @Override
    public String toString() {
        return "Jestem robotem o imieniu " + nazwa + " z identyfikatorem " + identyfikator + " ilosc moich zadan do wykonania"
                + " to " + ileZadan +
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

    @Override
    public void powitanie() {
        System.out.println(nazwa + " mowi witaj.");
    }
}
