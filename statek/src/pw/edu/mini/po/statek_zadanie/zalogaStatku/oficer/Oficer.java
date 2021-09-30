package pw.edu.mini.po.statek_zadanie.zalogaStatku.oficer;

import pw.edu.mini.po.statek_zadanie.stateek.Pasazer;
import pw.edu.mini.po.statek_zadanie.stateek.pietro.Pietro;
import pw.edu.mini.po.statek_zadanie.stateek.poklad.Poklad;
import pw.edu.mini.po.statek_zadanie.wyjatki.brakNaLiscieException;
import pw.edu.mini.po.statek_zadanie.zalogaStatku.oficer.OficerVisitor.SprawdzajBiletyImpl;

import java.util.HashSet;

public abstract class Oficer implements Comparable<Oficer> {

    public abstract void sprawdzajBilety(SprawdzajBiletyImpl visitor) throws brakNaLiscieException;

    public abstract void setPietra(Pietro[] pietra);

    public abstract void setListaPasazerow(HashSet<Pasazer> listaPasazerow);

    public abstract void setPoklad(Poklad poklad);

}
