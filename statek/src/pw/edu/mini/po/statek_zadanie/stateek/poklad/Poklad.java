package pw.edu.mini.po.statek_zadanie.stateek.poklad;

import pw.edu.mini.po.statek_zadanie.stateek.Pasazer;

import java.util.LinkedHashSet;
import java.util.Set;

public class Poklad {
    protected Set<Pasazer> pasazerowieNaPokladzie = new LinkedHashSet<Pasazer>();

    public Set<Pasazer> getPasazerowieNaPokladzie() {
        return pasazerowieNaPokladzie;
    }
}
