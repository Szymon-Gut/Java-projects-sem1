package com.company.Budynek.Ochroniarze;


import Exceptions.PrzepelnionaSalaException;
import com.company.Budynek.Hol;
import com.company.Budynek.Sala;
import com.company.Osoby.Uczestnik;

import java.util.Random;

public class OchroniarzMaly {
    private Sala salaMala;
    private Sala salaDuza;
    private Hol hol;

    public OchroniarzMaly(Sala salaMala, Sala salaDuza, Hol hol) {
        this.hol = hol;
        this.salaDuza = salaDuza;
        this.salaMala = salaMala;
    }

    public boolean check(Uczestnik uczestnik) {
        try {
            if (uczestnik.getWiek() >= 18) {
                if (new Random().nextBoolean()) {
                    salaMala.dodawajDoSali(uczestnik);
                    return true;
                } else {
                    salaDuza.dodawajDoSali(uczestnik);
                    return true;
                }
            } else {
                return false;
            }
        } catch (PrzepelnionaSalaException e) {
            e.printStackTrace();
        }
        return false;
    }

    public Sala getSalaMala() {
        return salaMala;
    }

    public Sala getSalaDuza() {
        return salaDuza;
    }

    public Hol getHol() {
        return hol;
    }
}
