package com.company;

import urzadzenia.UrzadzenieRTV;
import urzadzenia.enumy.Matryca;
import urzadzenia.enumy.RodzajSygnalu;
import urzadzenia.radio.Radio;
import urzadzenia.telewizory.Telewizor;
import urzadzenia.telewizory.TelewizorCRT;
import urzadzenia.telewizory.TelewizorPlaski;

public class Main {



    public static void main(String[] args) {

        TelewizorPlaski telewizorPlaski = new TelewizorPlaski();
        TelewizorCRT telewizorCRT = new TelewizorCRT();
        Radio radio = new Radio();

        UrzadzenieRTV [] urzadzenia = new UrzadzenieRTV[]{telewizorCRT,telewizorPlaski,radio};
        for (int i = 0; i < 2; i++) {
            urzadzenia[i].wlacz();
            System.out.println(urzadzenia[i]);
        }
        radio.wlacz();
        System.out.println(radio);
        radio.wylaczDzwiek();
    }
}
