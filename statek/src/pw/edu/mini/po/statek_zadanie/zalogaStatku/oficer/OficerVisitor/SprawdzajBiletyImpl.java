package pw.edu.mini.po.statek_zadanie.zalogaStatku.oficer.OficerVisitor;

import pw.edu.mini.po.statek_zadanie.stateek.Pasazer;
import pw.edu.mini.po.statek_zadanie.stateek.pietro.Pietro;
import pw.edu.mini.po.statek_zadanie.wyjatki.brakNaLiscieException;
import pw.edu.mini.po.statek_zadanie.zalogaStatku.oficer.LeniwyIPracowity.LeniwyOficer;
import pw.edu.mini.po.statek_zadanie.zalogaStatku.oficer.LeniwyIPracowity.PracowityOficer;

import java.util.Iterator;
import java.util.Random;

public class SprawdzajBiletyImpl implements OficerBilety {

    @Override
    public void sprawdzajBilety(LeniwyOficer oficer) throws brakNaLiscieException {
        Random rand = new Random();
        for (int i = 0; i < oficer.getPietra().length; i++) {
            Pietro pietro = oficer.getPietra()[i];
            for (int j = 0; j < pietro.getKajuty().length; j++) {
                for (int k = 0; k < pietro.getKajuty()[0].getMiejsca().length; k++) {
                    Pasazer miejsceDoSprawdzenia = pietro.getKajuty()[j].getMiejsca()[k];
                    if (miejsceDoSprawdzenia != null && !miejsceDoSprawdzenia.isSprawdzony()) {
                        if (rand.nextInt(10) == 0) {
                            if (!oficer.getListaPasazerow().contains(miejsceDoSprawdzenia)) {
                                throw new brakNaLiscieException(miejsceDoSprawdzenia);
                            } else {
                                miejsceDoSprawdzenia.setSprawdzony();
                            }
                        } else {
                            miejsceDoSprawdzenia.setSprawdzony();
                        }
                    }
                }
            }
        }
        Iterator<Pasazer> iterPokladu = oficer.getPoklad().getPasazerowieNaPokladzie().iterator();
        while (iterPokladu.hasNext()) {
            Pasazer pasazer = iterPokladu.next();
            if (!pasazer.isSprawdzony()) {
                if(rand.nextInt(10) == 0) {
                    if (!oficer.getListaPasazerow().contains(pasazer)) {
                        throw new brakNaLiscieException(pasazer);
                    } else {
                        pasazer.setSprawdzony();
                    }
                } else {
                    pasazer.setSprawdzony();
                }
            }
        }
    }

    @Override
    public void sprawdzajBilety(PracowityOficer oficer) throws brakNaLiscieException {
        for (int i = 0; i < oficer.getPietra().length; i++) {
            Pietro pietro = oficer.getPietra()[i];
            for (int j = 0; j < pietro.getKajuty().length; j++) {
                for (int k = 0; k < pietro.getKajuty()[0].getMiejsca().length; k++) {
                    Pasazer miejsceDoSprawdzenia = pietro.getKajuty()[j].getMiejsca()[k];
                    if (miejsceDoSprawdzenia != null && !miejsceDoSprawdzenia.isSprawdzony()) {
                        if (!oficer.getListaPasazerow().contains(miejsceDoSprawdzenia)) {
                            throw new brakNaLiscieException(miejsceDoSprawdzenia);
                        } else {
                            miejsceDoSprawdzenia.setSprawdzony();
                        }
                    }
                }
            }
        }
        Iterator<Pasazer> iterPokladu = oficer.getPoklad().getPasazerowieNaPokladzie().iterator();
        while (iterPokladu.hasNext()) {
            Pasazer pasazer = iterPokladu.next();
            if (!pasazer.isSprawdzony()) {
                if (!oficer.getListaPasazerow().contains(pasazer)) {
                    throw new brakNaLiscieException(pasazer);
                } else {
                    pasazer.setSprawdzony();
                }
            }
        }
    }
}
