package People.Initialization;

import People.Person;

import java.io.BufferedWriter;
import java.io.IOException;
import java.io.Writer;

public class BufferWriterExtended extends BufferedWriter {
    public BufferWriterExtended(Writer out) {
        super(out);
    }
    public void writePerson(Person person) {
        try {

            write(person.getName().getFirstName() + ";" + person.getName().getSecondName() + ";" +
                    person.getSurname().getSurname() + ";" + person.getSurname().getSurnamePopularity() + ";" +
                    person.getSex()  + ";" + person.getAge() + ";" + "\n");

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
