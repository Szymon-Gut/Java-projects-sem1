package com.company.Budynek.Ochroniarze;

import com.company.Osoby.Uczestnik;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class RejestrObcych {
    private Map<String, ArrayList<Uczestnik>> rejestr;

    public RejestrObcych() {
        this.rejestr = new HashMap<>();
    }

    public boolean ifExist(String imie, Uczestnik uczestnik) {
        if (rejestr.containsKey(uczestnik.getImie()))
            if (rejestr.get(imie).contains(uczestnik)) {
                return false;
            } else {
                return true;
        } else {
               return true;
        }
    }
    public void dodawajDoRejestru(Uczestnik uczestnik) {
        if (rejestr.containsKey(uczestnik.getImie())) {
            ArrayList<Uczestnik> result = rejestr.get(uczestnik.getImie());
            result.add(uczestnik);
            rejestr.put(uczestnik.getImie(),result);
        } else {
            ArrayList<Uczestnik> res = new ArrayList<>();
            res.add(uczestnik);
            rejestr.put(uczestnik.getImie(),res);
        }
    }

    public Map<String, ArrayList<Uczestnik>> getRejestr() {
        return rejestr;
    }

}
