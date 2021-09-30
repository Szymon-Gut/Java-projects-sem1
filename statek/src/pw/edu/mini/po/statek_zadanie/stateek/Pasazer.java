package pw.edu.mini.po.statek_zadanie.stateek;

import pw.edu.mini.po.statek_zadanie.stateek.pietro.Kajuta;
import pw.edu.mini.po.statek_zadanie.stateek.pietro.Pietro;

public class Pasazer {
    protected Pietro pietro;
    private boolean sprawdzony = false;
    private static int counter = 0;
    private int id;

    public Pasazer() {
        this.id = ++counter;
    }

    public void setPietro(Pietro pietro) {
        this.pietro = pietro;
    }

    public boolean szukajMiejsca() {
        boolean siedzi = false;
        for (int i = 0; i < this.pietro.getKajuty().length; i++) {
            Kajuta kajuta = this.pietro.getKajuty()[i];
            if (!siedzi) {
                for (int j = 0; j < kajuta.getMiejsca().length; j++) {
                    if (kajuta.getMiejsca()[j] == null) {
                        siedzi = true;
                        kajuta.getMiejsca()[j] = this;
                        this.pietro.iloscPasazerow++;
                        return true;
                    }
                }
            }
        }
        this.pietro = null;
        return false;
    }

    public boolean isSprawdzony() {
        return sprawdzony;
    }

    public void setSprawdzony() {
        this.sprawdzony = true;
    }

    @Override
    public String toString() {
        return "Pasazer{" + id + '}';
    }
}
