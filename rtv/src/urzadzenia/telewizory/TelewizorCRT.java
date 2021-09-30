package urzadzenia.telewizory;

import urzadzenia.enumy.Kolor;
import urzadzenia.enumy.RodzajSygnalu;

public class TelewizorCRT extends Telewizor {


    protected RodzajSygnalu rodzajSygnalu;
    protected Kolor kolor;

    public TelewizorCRT(boolean wlaczone, double przekatnaEkranu, Kolor kolor) {
        super(wlaczone, przekatnaEkranu);
        this.rodzajSygnalu = RodzajSygnalu.ANALOGOWE;
        this.odbieranyKanal = 0;
        this.kolor = kolor;
    }
    public TelewizorCRT() {
        super();
        this.rodzajSygnalu = RodzajSygnalu.ANALOGOWE;
        this.odbieranyKanal = 0;
        this.kolor = Kolor.CZARNOBIALY;
    }
    public TelewizorCRT(TelewizorCRT telewizorCRT) {
        super(telewizorCRT);
        this.odbieranyKanal = telewizorCRT.odbieranyKanal;
        this.rodzajSygnalu = RodzajSygnalu.ANALOGOWE;
        this.kolor = telewizorCRT.kolor;
    }

    @Override
    public String toString() {
        if (wlaczone) {
            return "Telewizor CRT o nazwie "
                    + nazwa + "wyprodukowany w roku " + dataProdukcji +
                    "o przekatnej " + przekatnaEkranu + " w kolorze " + kolor+ "odbiera sygnal "
                    + rodzajSygnalu + "na kanale " + odbieranyKanal;
        } else {
            return "Telewizor CRT o nazwie "
                    + nazwa + "wyprodukowany w roku " + dataProdukcji +
                    "o przekatnej " + przekatnaEkranu + "jest wylaczony";
        }
    }
}
