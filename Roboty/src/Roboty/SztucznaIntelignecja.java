package Roboty;

import Roboty.enumy.ReperezentacjaDanych;

public class SztucznaIntelignecja {
    protected ReperezentacjaDanych reperezentacjaDanych;

    public SztucznaIntelignecja(ReperezentacjaDanych reperezentacjaDanych) {
        this.reperezentacjaDanych = reperezentacjaDanych;
    }

    @Override
    public String toString() {
        return "SztucznaIntelignecja{" +
                  reperezentacjaDanych +
                '}';
    }
}
