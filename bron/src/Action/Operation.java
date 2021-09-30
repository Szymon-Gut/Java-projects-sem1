package Action;

import java.io.FileNotFoundException;
import java.io.IOException;

public interface Operation {
    void wczytaj() throws FileNotFoundException;
    void zapisz() throws FileNotFoundException;
    void group();
    void serializuj();
    void deserializuj();
}
