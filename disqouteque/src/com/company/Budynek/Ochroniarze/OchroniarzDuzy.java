package com.company.Budynek.Ochroniarze;

import Exceptions.PrzepelnionaSalaException;
import com.company.Budynek.Hol;
import com.company.Budynek.Sala;
import com.company.Budynek.visitor.VisitorImpl;
import com.company.Osoby.Uczestnik;

import java.util.List;
import java.util.Random;

public class OchroniarzDuzy extends OchroniarzMaly {
    private RejestrObcych rejestrObcych;

    public OchroniarzDuzy(Sala salaMala, Sala salaDuza, Hol hol, RejestrObcych rejestrObcych) {
        super(salaMala, salaDuza, hol);
        this.rejestrObcych = rejestrObcych;
    }

    @Override
    public boolean check(Uczestnik uczestnik) {
        VisitorImpl visitor = new VisitorImpl(rejestrObcych);
        if (uczestnik.getWiek() >= 18) {
            uczestnik.apply(visitor);
            try {
                if (new Random().nextBoolean()) {
                    this.getSalaMala().dodawajDoSali(uczestnik);
                    return true;
                } else {
                    this.getSalaDuza().dodawajDoSali(uczestnik);
                    return true;
                }
            } catch (PrzepelnionaSalaException e) {
                e.printStackTrace();
            }

        }
        return false;
    }

    public void printStrangers() {
        for (List<Uczestnik> valueList : rejestrObcych.getRejestr().values()) {
            for (Uczestnik uczestnik : valueList) {
                System.out.println(uczestnik);
            }
        }
    }

}
