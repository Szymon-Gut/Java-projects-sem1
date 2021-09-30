package urzadzenia;

import urzadzenia.telewizory.interfejsy.Odbieranie;

import java.time.LocalDate;
import java.util.Random;

public abstract class UrzadzenieRTV implements Odbieranie {
    protected LocalDate dataProdukcji;
    protected String nazwa;
    protected int iloscWlaczen;
    protected boolean wlaczone;
    protected final static Random random = new Random();
    protected static int nrSeryjny = 0;
    protected boolean czyZepsute = false;


    public UrzadzenieRTV() {
        this.wlaczone = true;
        this.iloscWlaczen = 0;
        this.nazwa = randomname() + (++nrSeryjny);
        this.dataProdukcji = LocalDate.now();
        this.czyZepsute = false;
    }

    public UrzadzenieRTV(boolean wlaczone) {
        this.dataProdukcji = LocalDate.now();
        this.wlaczone = wlaczone;
        this.nazwa = randomname() + (++nrSeryjny);
        this.iloscWlaczen = random.nextInt(5) + 3;
        this.czyZepsute = false;
    }

    public void napraw() {
        this.czyZepsute = false;
    }
    public void wlacz() {
        if (!this.czyZepsute) {
            this.wlaczone = true;
        } else {
            System.out.println("Urzadzenie jest zepsute");
        }
    }
    public void wylacz(){
            this.wlaczone = false;
        }
    @Override
    public String toString() {
        return "UrzadzenieRTV" +
                "o nazwie " + nazwa + "wyprodukowany w roku" + dataProdukcji;
    }
    private String randomname() {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < 5; i++) {
            sb.append((char)(random.nextInt(26) + 65));
        }
        return sb.toString();
    }
}
