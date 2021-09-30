package People.Initialization;

import People.Initialization.Initializer;

public class MainHelper {
    public MainHelper() {
        Initializer initializer = new Initializer();
        initializer.wczytaj();
        initializer.generuj();
        initializer.group();
        initializer.zapisz();
        initializer.serializuj();
        initializer.deserializuj();
        initializer.zapiszBufferedWriterExtended();
    }
}
