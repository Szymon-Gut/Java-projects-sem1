package Roboty;

import Roboty.enumy.Nazwa;
import Roboty.enumy.ReperezentacjaDanych;
import Roboty.interfejsy.Porozumienie;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.Random;

public abstract class Robot implements Porozumienie {
    protected LocalDate localDate;
    protected Nazwa nazwa;
    protected int identyfikator;
    protected int ileZadan;
    protected SztucznaIntelignecja sztucznaIntelignecja;
    protected  static Random random = new Random();

    public Robot(LocalDate localDate, Nazwa nazwa, int identyfikator, SztucznaIntelignecja sztucznaIntelignecja) {
        this.localDate = localDate;
        this.nazwa = nazwa;
        this.identyfikator = identyfikator;
        this.ileZadan = 0;
        this.sztucznaIntelignecja = sztucznaIntelignecja;
    }
    public Robot(){
      this.localDate = LocalDate.now();
      this.nazwa = Nazwa.Adam100;
      this.identyfikator = generatorId();
      this.ileZadan = 0;
      this.sztucznaIntelignecja = null;
    }


    @Override
    public void meldunek() {
        long days = ChronoUnit.DAYS.between(LocalDate.now(), localDate);
        System.out.println("Zyje juz " + days + " lat.");
    }

    @Override
    public String toString() {
        return "Jestem robotem o imieniu " + nazwa + " z identyfikatorem " + identyfikator + " ilosc moich zadan do wykonania"
                + " to " + ileZadan + " reprezentacja danych w moim systemie jest " + sztucznaIntelignecja;
    }
    protected static int generatorId(){
        Random random = new Random();
        return random.nextInt(90000) + 10000;
    }
    public void zadanieWykonaj() {
        ileZadan += random.nextInt(20) + 1;
    }
}

