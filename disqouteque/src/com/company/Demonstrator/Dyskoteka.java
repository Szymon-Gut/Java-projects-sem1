package com.company.Demonstrator;

import com.company.Budynek.*;
import com.company.Budynek.Ochroniarze.OchroniarzDuzy;
import com.company.Budynek.Ochroniarze.OchroniarzMaly;
import com.company.Budynek.Ochroniarze.RejestrObcych;
import com.company.Osoby.Uczestnik;

import java.util.Iterator;
import java.util.Random;

public class Dyskoteka {
    Sala salaMala;
    Sala salaDuza;
    Hol hol;
    OchroniarzMaly ochroniarzMaly;
    OchroniarzDuzy ochroniarzDuzy;

    public Dyskoteka() {
        this.salaMala = new Sala(51);
        this.salaDuza = new Sala(75);
        this.hol = new Hol();
        this.ochroniarzMaly = new OchroniarzMaly(salaMala, salaDuza, hol);
        this.ochroniarzDuzy = new OchroniarzDuzy(salaMala, salaDuza, hol, new RejestrObcych());
    }

    public void inviteAll() {
        Iterator<Uczestnik> iterator = hol.uczestnicyWHolu.iterator();
        while (iterator.hasNext()) {
            Uczestnik uczestnik = iterator.next();
            if (new Random().nextBoolean()) {
                if (ochroniarzDuzy.check(uczestnik)) {
                    iterator.remove();
                }

            } else {
                if (ochroniarzMaly.check(uczestnik)) {
                    iterator.remove();
                }
            }
        }
    }


    public void goLive() {
        inviteAll();
        ochroniarzDuzy.printStrangers();
    }


}
