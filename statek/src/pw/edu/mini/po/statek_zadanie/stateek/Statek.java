package pw.edu.mini.po.statek_zadanie.stateek;

import pw.edu.mini.po.statek_zadanie.stateek.maszynownia.InterfejsMaszynowni;
import pw.edu.mini.po.statek_zadanie.stateek.pietro.Pietro;
import pw.edu.mini.po.statek_zadanie.stateek.poklad.Poklad;
import pw.edu.mini.po.statek_zadanie.zalogaStatku.KapitanStatku;
import pw.edu.mini.po.statek_zadanie.zalogaStatku.oficer.LeniwyIPracowity.LeniwyOficer;
import pw.edu.mini.po.statek_zadanie.zalogaStatku.oficer.Oficer;
import pw.edu.mini.po.statek_zadanie.zalogaStatku.oficer.LeniwyIPracowity.PracowityOficer;

import java.util.*;

public class Statek<T extends InterfejsMaszynowni> {
    private Set<Pasazer> listaPasazerow = new LinkedHashSet<>();
    private T maszynownia;
    private KapitanStatku kapitanStatku;
    private Set<Oficer> oficerowie = new TreeSet<>();
    private Pietro[] pietra;
    private Poklad poklad;

    public Statek(T t) {
        this.maszynownia = t;
        Random rand = new Random();
        // Ilosc pieter od 5 do 8
        this.pietra = new Pietro[rand.nextInt(4) + 5];
        for (int i = 0; i < pietra.length; i++) {
            pietra[i] = new Pietro();
        }
        this.poklad = new Poklad();
//        true - pracowity, false - leniwy
        boolean[] oficerowieTypyCzyPracowity = {true, true, false, true, false};
        for (int i = 0; i < 5; i++) {
            if (oficerowieTypyCzyPracowity[i]) {
                this.oficerowie.add(new PracowityOficer());
            } else {
                this.oficerowie.add(new LeniwyOficer());
            }

        }
        System.out.println("Oficerowie w treesetcie: ");
        System.out.println(oficerowie + "\n");
        //      Kapitan statku
        this.kapitanStatku = new KapitanStatku(this);
    }

    public Set<Pasazer> getListaPasazerow() {
        return listaPasazerow;
    }

    public Pietro[] getPietra() {
        return pietra;
    }

    public Poklad getPoklad() {
        return poklad;
    }

    public T getMaszynownia() {
        return maszynownia;
    }

    public Set<Oficer> getOficerowie() {
        return oficerowie;
    }
}
