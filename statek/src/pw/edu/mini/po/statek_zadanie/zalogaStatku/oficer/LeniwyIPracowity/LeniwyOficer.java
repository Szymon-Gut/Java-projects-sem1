package pw.edu.mini.po.statek_zadanie.zalogaStatku.oficer.LeniwyIPracowity;

import pw.edu.mini.po.statek_zadanie.stateek.Pasazer;
import pw.edu.mini.po.statek_zadanie.stateek.pietro.Pietro;
import pw.edu.mini.po.statek_zadanie.stateek.poklad.Poklad;
import pw.edu.mini.po.statek_zadanie.wyjatki.brakNaLiscieException;
import pw.edu.mini.po.statek_zadanie.zalogaStatku.oficer.Oficer;
import pw.edu.mini.po.statek_zadanie.zalogaStatku.oficer.OficerVisitor.SprawdzajBiletyImpl;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Random;

public class LeniwyOficer extends Oficer {
    private Pietro[] pietra;
    private HashSet<Pasazer> listaPasazerow;
    private Poklad poklad;
    private static int counter = 0;
    private int id;

    public LeniwyOficer() {
        super();
        this.id = ++counter;
    }


    @Override
    public void sprawdzajBilety(SprawdzajBiletyImpl visitor) throws brakNaLiscieException {
        visitor.sprawdzajBilety(this);
    }

    @Override
    public void setPietra(Pietro[] pietra) {
        this.pietra = pietra;
    }

    @Override
    public void setListaPasazerow(HashSet<Pasazer> listaPasazerow) {
        this.listaPasazerow = listaPasazerow;
    }

    @Override
    public void setPoklad(Poklad poklad) {
        this.poklad = poklad;
    }

    public Pietro[] getPietra() {
        return pietra;
    }

    public HashSet<Pasazer> getListaPasazerow() {
        return listaPasazerow;
    }

    public Poklad getPoklad() {
        return poklad;
    }

    @Override
    public String toString() {
        return "LeniwyOficer{"+ id +"}";
    }

    @Override
    public int compareTo(Oficer o) {
        if (o instanceof LeniwyOficer) {
            return 1;
        } else {
            return -1;
        }
    }
}
