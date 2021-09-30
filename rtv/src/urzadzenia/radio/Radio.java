package urzadzenia.radio;

import urzadzenia.UrzadzenieRTV;
import urzadzenia.enumy.ZakresFal;
import urzadzenia.telewizory.interfejsy.Udzwiekowienie;

final public class Radio extends UrzadzenieRTV implements Udzwiekowienie {
    protected String czestotliwosc;
    protected ZakresFal zakresFal;
    protected int dlugoscFali;




    public Radio() {
        super();
        this.zakresFal = ZakresFal.Krotkie;

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
    public void rodzajSygnalu() {
        if (dlugoscFali >= 1 && dlugoscFali < 10) {
            this.zakresFal = ZakresFal.UHF;
        } else if (dlugoscFali >= 10 && dlugoscFali < 200) {
            this.zakresFal = ZakresFal.Krotkie;
        } else if (dlugoscFali >= 200 && dlugoscFali < 1000) {
            this.zakresFal = ZakresFal.Srednie;
        } else if (dlugoscFali >= 1000 && dlugoscFali < 20000) {
            this.zakresFal = ZakresFal.Dlugie;
        }
    }
}
