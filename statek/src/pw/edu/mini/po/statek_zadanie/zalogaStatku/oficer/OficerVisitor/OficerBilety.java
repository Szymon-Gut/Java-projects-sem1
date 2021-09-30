package pw.edu.mini.po.statek_zadanie.zalogaStatku.oficer.OficerVisitor;

import pw.edu.mini.po.statek_zadanie.wyjatki.brakNaLiscieException;
import pw.edu.mini.po.statek_zadanie.zalogaStatku.oficer.LeniwyIPracowity.LeniwyOficer;
import pw.edu.mini.po.statek_zadanie.zalogaStatku.oficer.LeniwyIPracowity.PracowityOficer;

public interface OficerBilety {
    void sprawdzajBilety(LeniwyOficer oficer) throws brakNaLiscieException;
    void sprawdzajBilety(PracowityOficer oficer) throws brakNaLiscieException;
}
