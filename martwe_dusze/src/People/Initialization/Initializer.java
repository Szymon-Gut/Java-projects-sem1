package People.Initialization;
import People.Name;
import People.Person;
import People.Surname;

import java.io.*;
import java.util.*;

public class Initializer implements Generator{


    private List<Name> imionaLista = new ArrayList<>();
    private List<Surname> nazwiskaLista = new ArrayList<>();
    private List<Person> osobyLista = new ArrayList<>();
    private Map<Integer,Set<Person>> groupedPeople = new TreeMap<>();
    private Set<Integer> wiekSet = new HashSet<>();
    private List<Person> poDeserializacji = new ArrayList<>();


    public void wczytaj() {
        try {
            File imiona = new File("D:\\Users\\Szymon\\martwe_dusze\\imiona.txt");
            Scanner scanner = new Scanner(imiona);
            while (scanner.hasNextLine()) {
                String theLine = scanner.nextLine();
                if (!theLine.isEmpty()) {
                    String[] tablicaImiona = theLine.split(" ");
                    Name name;
                    if (tablicaImiona.length == 1) {
                        name = new Name(tablicaImiona[0], "");
                    } else {
                        name = new Name(tablicaImiona[0], tablicaImiona[1]);
                    }
                    imionaLista.add(name);
                }
            }
            scanner.close();
            File nazwiska = new File("D:\\Users\\Szymon\\martwe_dusze\\nazwiska.txt");
            Scanner scanner1 = new Scanner(nazwiska, "ISO-8859-2");
            while (scanner1.hasNextLine()) {
                String nazwisko = scanner1.nextLine();
                if (!nazwisko.isEmpty()) {
                    String[] tablicaNazwisko = nazwisko.split(";");
                    String surname = tablicaNazwisko[0];
                    String surnamePopularity = tablicaNazwisko[1];
                    Surname surname1 = new Surname(surname, Double.parseDouble(surnamePopularity.replace(",", ".")));
                    nazwiskaLista.add(surname1);
                }
            }
            scanner1.close();
        }catch (FileNotFoundException f) {
            f.printStackTrace();
        }
    }



    public void generuj() {
        Random random = new Random();
        int counter = 0;
        for (int i = 0; i < 10000; i++){
            int indexImiona  = random.nextInt(imionaLista.size());
            int indexNazwiska = random.nextInt(nazwiskaLista.size());
            Name name = imionaLista.get(indexImiona);
            String imie = name.getFirstName();
            Surname surname = nazwiskaLista.get(indexNazwiska);
            String nazwisko = surname.getSurname();
            String sex;
            if (imie.charAt(imie.length() - 1) == 'a') {
                sex = "kobieta";
            } else {
                sex = "mezczyzna";
            }
            if(sex.equals("kobieta")) {
                while(nazwisko.charAt(nazwisko.length() - 1) != 'a') {
                    int idx = random.nextInt(nazwiskaLista.size());
                    surname = nazwiskaLista.get(idx);
                    nazwisko = surname.getSurname();
                }
                Person person = new Person(name,surname,sex,random.nextInt(8)+18);
                osobyLista.add(person);
            } else {
                while(nazwisko.charAt(nazwisko.length() - 1) == 'a') {
                    int idx = random.nextInt(nazwiskaLista.size());
                    surname = nazwiskaLista.get(idx);
                    nazwisko = surname.getSurname();
                }
                int wiek = random.nextInt(8)+18;
                Person person = new Person(name,surname,sex,wiek);
                wiekSet.add(wiek);
                if (osobyLista.contains(person)) {
                    System.out.println( person + " juz istnieje");
                    counter++;
                    continue;
                } else{
                    osobyLista.add(person);
                }
            }
        }
        System.out.println(counter);
    }




    public void group() {
        if (!osobyLista.isEmpty()) {
            Collections.sort(osobyLista, (o1, o2) -> {
                if (o1.getName().compare(o2.getName()) == 0) {
                    return o1.getSurname().compare(o2.getSurname());
                } else {
                    return o1.getName().compare(o2.getName());
                }
            });
        }
        for (Person person : osobyLista) {
            if(!groupedPeople.containsKey(person.getAge())) {
                Set<Person> set = new HashSet<>();
                set.add(person);
                groupedPeople.put(person.getAge(),set);
            } else {
                groupedPeople.get(person.getAge()).add(person);

            }
        }
    }




    public void zapisz(){
        Iterator<Integer> iterator = wiekSet.iterator();
        try {
            while (iterator.hasNext()) {
                int wiek = iterator.next();
                PrintWriter printWriter = new PrintWriter("D:\\Users\\Szymon\\martwe_dusze\\plik_wiek\\ludzie_" + wiek + ".txt","Cp1250");
                Set<Person> doZapisu = groupedPeople.get(wiek);
                Iterator<Person> personIterator = doZapisu.iterator();
                while(personIterator.hasNext()) {
                    Person person = personIterator.next();
                    printWriter.write(person.getName().getFirstName() + ";" + person.getName().getSecondName() + ";" +
                            person.getSurname().getSurname() + ";" + person.getSurname().getSurnamePopularity() + ";" +
                            person.getSex()  + ";" + person.getAge() + ";" + "\n");
                }
                printWriter.close();
                System.out.println("Zapisano " + doZapisu.size() + " osob w wieku " + wiek + " do pliku ludzie_" + wiek + ".txt");
            }
        } catch (FileNotFoundException | UnsupportedEncodingException f) {
            f.printStackTrace();
        }
    }
    public void zapiszBufferedWriterExtended(){
        Iterator<Integer> iterator = wiekSet.iterator();
        int iloscKobiet = 0;
        try {
            while (iterator.hasNext()) {
                int wiek = iterator.next();
                BufferWriterExtended bufferWriterExtended = new BufferWriterExtended(new FileWriter("D:\\Users\\Szymon\\martwe_dusze\\plik_wiek_C\\ludzie_" + wiek + ".txt"));
                Set<Person> doZapisu = groupedPeople.get(wiek);
                Iterator<Person> iterator1 = doZapisu.iterator();
                while(iterator1.hasNext()) {
                    Person person = iterator1.next();
                    if(person.getSex().equals("kobieta")) {
                        iloscKobiet++;
                    }
                    bufferWriterExtended.writePerson(person);
                }
                if (wiek <= 21) {
                    System.out.println("Zapisano " + iloscKobiet + "w wieku " + wiek);
                }
                bufferWriterExtended.close();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void serializuj() {
        FileOutputStream file;
        try {
            file = new FileOutputStream("D:\\Users\\Szymon\\martwe_dusze\\serialized.txt");
            ObjectOutputStream objectOutputStream = new ObjectOutputStream(file);
            Iterator<Person> personIterator = osobyLista.iterator();
            while(personIterator.hasNext()) {
                objectOutputStream.writeObject(personIterator.next());
            }
            file.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void deserializuj(){
        FileInputStream fileInputStream = null;
        Person person;
        try {
            fileInputStream = new FileInputStream("D:\\Users\\Szymon\\martwe_dusze\\serialized.txt");
            ObjectInputStream objectInputStream = new ObjectInputStream(fileInputStream);
            while(true) {
                Object readobject = objectInputStream.readObject();
                if (readobject instanceof Person) {
                    person = (Person) readobject;
                    poDeserializacji.add(person);
                }
            }
        } catch (IOException | ClassNotFoundException e) {
            try {
                assert fileInputStream != null;
                fileInputStream.close();
                System.out.println("Deserializacja dokonana. Ilosc nowych obiektow: " + poDeserializacji.size());
            }catch (IOException x) {
                x.printStackTrace();
            }
        }
    }
}
