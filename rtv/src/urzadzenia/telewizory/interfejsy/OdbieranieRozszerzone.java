package urzadzenia.telewizory.interfejsy;

import urzadzenia.enumy.RodzajSygnalu;
import urzadzenia.telewizory.interfejsy.Odbieranie;

public interface OdbieranieRozszerzone extends Odbieranie {
    void odbieranySygnal(RodzajSygnalu rodzajSygnalu);
}
