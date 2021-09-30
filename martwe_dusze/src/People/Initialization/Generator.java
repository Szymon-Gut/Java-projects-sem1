package People.Initialization;

import java.io.IOException;

public interface Generator {
    void wczytaj();
    void generuj();
    void group();
    void zapisz();
    void serializuj();
    void deserializuj() throws IOException;
}
