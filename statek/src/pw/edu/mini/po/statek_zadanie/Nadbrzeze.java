package pw.edu.mini.po.statek_zadanie;

import pw.edu.mini.po.statek_zadanie.stateek.Pasazer;

import java.util.LinkedHashSet;

public class Nadbrzeze {
    public LinkedHashSet<Pasazer> pasazerowie = new LinkedHashSet<>();

    public Nadbrzeze() {
        for (int i = 0; i < 500; i++) {
            pasazerowie.add(new Pasazer());
        }
    }
}
