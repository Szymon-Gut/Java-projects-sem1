package urzadzenia.telewizory;

import urzadzenia.enumy.Matryca;
import urzadzenia.telewizory.interfejsy.OdbieranieRozszerzone;
import urzadzenia.enumy.RodzajSygnalu;

public class TelewizorPlaski extends Telewizor implements OdbieranieRozszerzone {
    protected double przekatnaEkranu;
    protected RodzajSygnalu rodzajSygnalu;
    protected Matryca matryca;


    public TelewizorPlaski(boolean wlaczone, double przekatnaEkranu, Matryca matryca, RodzajSygnalu rodzajSygnalu) {
        super(wlaczone, przekatnaEkranu);
        this.matryca = matryca;
        this.rodzajSygnalu = rodzajSygnalu;
        this.przekatnaEkranu = przekatnaEkranu;
        rodzajSygnalu();

    }

    public TelewizorPlaski(TelewizorPlaski telewizorPlaski) {
        super(telewizorPlaski);
        this.matryca = telewizorPlaski.matryca;
    }
    public TelewizorPlaski() {
        super();
        this.matryca = Matryca.LCD;
        this.rodzajSygnalu = RodzajSygnalu.CYFROWE;
    }

    @Override
    public String toString() {
        if (wlaczone) {
            return "Telewizor " + matryca + " o nazwie "
                    + nazwa + " wyprodukowany w roku " + dataProdukcji +
                    " o przekatnej " + przekatnaEkranu + " odbiera sygnal "
                    + rodzajSygnalu + " na kanale " + odbieranyKanal;
        } else {
            return "Telewizor " + matryca+ " o nazwie "
                    + nazwa + " wyprodukowany w roku " + dataProdukcji +
                    "o przekatnej " + przekatnaEkranu + "cale jest wylaczony";
        }
    }


    @Override
    public void wlaczObraz() {
        super.wlaczObraz();
    }

    @Override
    public void wylaczObraz() {
        super.wylaczObraz();
    }

    @Override
    public void wlaczDzwiek() {
        super.wlaczDzwiek();
    }

    @Override
    public void wylaczDzwiek() {
        super.wylaczDzwiek();
    }

    @Override
    public void odbieranySygnal(RodzajSygnalu rodzajSygnalu) {
        this.rodzajSygnalu = rodzajSygnalu;
    }
}
