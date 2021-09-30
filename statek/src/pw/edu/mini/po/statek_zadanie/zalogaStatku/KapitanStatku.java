package pw.edu.mini.po.statek_zadanie.zalogaStatku;

import pw.edu.mini.po.statek_zadanie.*;
import pw.edu.mini.po.statek_zadanie.stateek.Pasazer;
import pw.edu.mini.po.statek_zadanie.stateek.pietro.Pietro;
import pw.edu.mini.po.statek_zadanie.stateek.poklad.Poklad;
import pw.edu.mini.po.statek_zadanie.stateek.Statek;
import pw.edu.mini.po.statek_zadanie.wyjatki.awariaStatkuException;
import pw.edu.mini.po.statek_zadanie.wyjatki.brakNaLiscieException;
import pw.edu.mini.po.statek_zadanie.zalogaStatku.oficer.Oficer;
import pw.edu.mini.po.statek_zadanie.zalogaStatku.oficer.OficerVisitor.SprawdzajBiletyImpl;

import java.util.*;

public class KapitanStatku {
    private Statek statek;
    private HashSet<Pasazer> listaPasazerow;
    private Pietro[] pietra;
    private Nadbrzeze nadbrzeze;
    private Poklad poklad;
    private boolean czyKoniec;
    private int iluPasazerowDodajemy;


    public KapitanStatku(Statek statek) {
        this.statek = statek;
        this.listaPasazerow = (HashSet<Pasazer>) statek.getListaPasazerow();
        this.pietra = statek.getPietra();
        this.nadbrzeze = new Nadbrzeze();
        this.poklad = statek.getPoklad();
        zaladujPasazerow();
        for (int i = 0; i < this.pietra.length; i++) {
            System.out.println("Ilosc osob na pietrze ["+(i+1)+"]: " + this.pietra[i].iloscPasazerow );
        }
        System.out.println(Arrays.toString(this.pietra[0].getKajuty()[0].getMiejsca()));
        System.out.println(Arrays.toString(this.poklad.getPasazerowieNaPokladzie().toArray()));
        System.out.println(this.poklad.getPasazerowieNaPokladzie().size());
        System.out.println();
        System.out.println("Ilosc na liscie pasazerow: " + this.listaPasazerow.size());
        plyniemy();
        System.out.println("Ilosc na liscie  po sprawdzeniu biletow (ma byc 500): " + this.listaPasazerow.size());
    }

    private void zaladujPasazerow() {
//    co 10 pasazer nie jest wpisywany na liste pasazerow.
        Random rand = new Random();
        Iterator<Pasazer> iter = nadbrzeze.pasazerowie.iterator();
        int i = 1;
        while (iter.hasNext()) {
            Pasazer pasazer = iter.next();
            if (i % 10 != 0) {
                this.listaPasazerow.add(pasazer);
            }
            pasazer.setPietro(this.pietra[rand.nextInt(this.pietra.length)]);
            if (!pasazer.szukajMiejsca()) {
                this.poklad.getPasazerowieNaPokladzie().add(pasazer);
            }
            i++;
        }
    }

    private void plyniemy() {
        int counter = 0;
        Random rand = new Random();
        int size = this.statek.getOficerowie().size();
        int element = rand.nextInt(size);
        int l = 0;
        // Tymczasowo wybieram sobie pierwszego
        Iterator<Oficer> iter = this.statek.getOficerowie().iterator();
        Oficer wylosowanyOficer = iter.next();
        System.out.println(wylosowanyOficer);
        for(Object oficer : this.statek.getOficerowie()) {
            if (l == element) {
                wylosowanyOficer = (Oficer) oficer;
            }
            l++;
        }
        wylosowanyOficer.setPoklad(this.poklad);
        wylosowanyOficer.setPietra(this.pietra);
        wylosowanyOficer.setListaPasazerow(this.listaPasazerow);
        System.out.println(wylosowanyOficer);
        SprawdzajBiletyImpl visitor = new SprawdzajBiletyImpl();
        try {
            while(!czyKoniec) {
                this.statek.getMaszynownia().plyn();
                counter++;
                if(counter % 2137 == 0) {
                    throw new awariaStatkuException();
                }
                try {
                    wylosowanyOficer.sprawdzajBilety(visitor);
                } catch (brakNaLiscieException e) {
                    this.statek.getMaszynownia().stoj();
                    iluPasazerowDodajemy++;
                    this.listaPasazerow.add(e.getPasazerBezBiletu());
                    continue;
                }
                czyKoniec = true;
                System.out.println("Wszyscy pasazerowie zostali sprawdzeni.\n" + "Ilosc pasazerow nie bedacych na " +
                        "liscie to: " + iluPasazerowDodajemy);
            }
        } catch(awariaStatkuException e) {
            czyKoniec = true;
        }
    }
}


