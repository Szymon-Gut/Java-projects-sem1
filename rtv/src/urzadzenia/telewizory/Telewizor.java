package urzadzenia.telewizory;

import urzadzenia.telewizory.interfejsy.Obrazowanie;
import urzadzenia.enumy.RodzajSygnalu;
import urzadzenia.telewizory.interfejsy.Udzwiekowienie;
import urzadzenia.UrzadzenieRTV;

import java.util.Random;

public abstract class Telewizor extends UrzadzenieRTV implements Udzwiekowienie, Obrazowanie {

    protected double przekatnaEkranu;
    protected RodzajSygnalu rodzajSygnalu;
    protected int odbieranyKanal;
    protected final static Random random = new Random();


    public Telewizor() {
        super();
        this.przekatnaEkranu = 5;
        this.odbieranyKanal = random.nextInt(100);
        this.rodzajSygnalu = RodzajSygnalu.ANALOGOWE;

//
    }
    public Telewizor(Telewizor telewizor) {
        super(telewizor.wlaczone);
        this.przekatnaEkranu = telewizor.przekatnaEkranu;
        this.odbieranyKanal= telewizor.odbieranyKanal;
        this.rodzajSygnalu = telewizor.rodzajSygnalu;
    }


    public Telewizor(boolean wlaczone,double przekatnaEkranu) {
        super(wlaczone);
        this.przekatnaEkranu = przekatnaEkranu;
        rodzajSygnalu();
//
    }


    @Override
    public void rodzajSygnalu() {
        this.odbieranyKanal =  random.nextInt(100);
    }

    @Override
    public void wlaczObraz() {
        System.out.println("Obraz zostal wlaczony");
    }

    @Override
    public void wylaczObraz() {
        System.out.println("Obraz zostal wylaczony");
    }

    @Override
    public void wlaczDzwiek() {
        System.out.println("Dzwiek zostal wlaczony");
    }

    @Override
    public void wylaczDzwiek() {
        System.out.println("Dzwiek zostal wylaczony");
    }

    @Override
    public String toString() {
        if (wlaczone) {
            return "Telewizor o nazwie "
                    + nazwa + "wyprodukowany w roku " + dataProdukcji +
                    "o przekatnej " + przekatnaEkranu + " na kanale " + odbieranyKanal;
        } else {
            return "Telewizor o nazwie "
                    + nazwa + "wyprodukowany w roku " + dataProdukcji +
                    "o przekatnej " + przekatnaEkranu + "jest wylaczony";
        }
    }
}
