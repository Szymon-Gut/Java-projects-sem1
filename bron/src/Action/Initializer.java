package Action;

import Bron.Caliber;
import Bron.Weapon;
import com.company.LineNumberReaderExtended;

import java.io.*;
import java.util.*;


public class Initializer implements Operation{
    Set<Weapon> wczytaneBronie = new HashSet<>();
    Set<Caliber> kalibryBroni = new HashSet<>();
    Map<Caliber,List<Weapon>> groupedWeapons = new HashMap<>();
    List<Weapon> poDeserializacji = new LinkedList<>();


    public void wczytaj(){
        try {
            File bronie = new File("." + File.separator + "generated_weapon.txt");
            Scanner scanner = new Scanner(bronie);
            while (scanner.hasNextLine()) {
                String linia = scanner.nextLine();
                if (!linia.isEmpty()) {
                    String[] daneTechniczne = linia.split(";");
                    String name = daneTechniczne[0];
                    String kaliber = daneTechniczne[1];
                    String[] kaliberDwaCzlony = kaliber.split(" ");
                    String kaliberValue;
                    String additionalValue;
                    if (kaliberDwaCzlony.length == 1) {
                        kaliberValue = kaliberDwaCzlony[0];
                        additionalValue = "";
                    } else {
                        kaliberValue = kaliberDwaCzlony[0];
                        additionalValue = kaliberDwaCzlony[1];
                    }
                    String serialNumber = daneTechniczne[2];
                    String unfit = daneTechniczne[3];
                    String hasFingerprints = daneTechniczne[4];
                    Caliber caliber = new Caliber(kaliberValue, additionalValue);
                    kalibryBroni.add(caliber);
                    Weapon weapon = new Weapon(name, caliber, Integer.parseInt(serialNumber.substring(7)),
                            Double.parseDouble(unfit.replace(",", ".")), Boolean.parseBoolean(hasFingerprints));
                    wczytaneBronie.add(weapon);

                }
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        System.out.println(wczytaneBronie);
        System.out.println("Ilosc wczytanych broni: " + wczytaneBronie.size());
    }


    public List<Weapon> wczytajLineReader(){
        File file = new File("." + File.separator + "generated_weapon_bad.txt");
        List<Weapon> bronie = new ArrayList<>();
        try {
            LineNumberReaderExtended lineNumberReaderExtended = new LineNumberReaderExtended(new FileReader(file));
            String tmpString = "";
            tmpString = lineNumberReaderExtended.readLine();
            lineNumberReaderExtended.setCurrentLine(tmpString);
            while (tmpString != null) {
                if (tmpString.isEmpty()) {
                    tmpString = lineNumberReaderExtended.readLine();
                    continue;
                }
                lineNumberReaderExtended.setCurrentLine(tmpString);
                bronie.add(lineNumberReaderExtended.getWeapon());
                tmpString = lineNumberReaderExtended.readLine();
            }
            lineNumberReaderExtended.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return bronie;
    }
    public void group() {
        Iterator<Weapon> iter = wczytaneBronie.iterator();
        while(iter.hasNext()){
            Weapon weapon = iter.next();
            if(!groupedWeapons.containsKey(weapon.getCaliber())){
                List<Weapon> list = new ArrayList<>();
                list.add(weapon);
                groupedWeapons.put(weapon.getCaliber(),list);
            } else {
                groupedWeapons.get(weapon.getCaliber()).add(weapon);
            }
        }
        Iterator<Caliber> iterator = kalibryBroni.iterator();
        while(iterator.hasNext()) {
            Caliber caliber = iterator.next();
            System.out.println(caliber);
            System.out.println(groupedWeapons.get(caliber));
            System.out.println("\n\n\n\n\n\n");
        }
    }
    public void zapisz() throws FileNotFoundException {
        Iterator<Caliber> iterator = kalibryBroni.iterator();
        while(iterator.hasNext()) {
            Caliber caliber = iterator.next();
            PrintWriter printWriter = new PrintWriter("D:\\Users\\Szymon\\bron\\bronie_wg_kalibru\\weapon_" +
                                                        caliber.toString() + ".txt");
            List<Weapon> doZapisu = groupedWeapons.get(caliber);
            for(Weapon weapon : doZapisu) {
                printWriter.write(weapon.toString() + "\n");
            }
            printWriter.close();
        }

    }

    @Override
    public void serializuj() {
        //mozna posortowac tutaj zeby pozniej nie trzeba bylo
        FileOutputStream file = null;
        try {
            file = new FileOutputStream("D:\\Users\\Szymon\\bron\\serialized.txt");
            ObjectOutputStream out = new ObjectOutputStream(file);
            Iterator<Weapon> weaponIterator = wczytaneBronie.iterator();
            while(weaponIterator.hasNext()) {
                out.writeObject(weaponIterator.next());
            }
            file.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void deserializuj() {
        FileInputStream fileInputStream = null;
        Weapon weapon = null;
        try {
            fileInputStream = new FileInputStream("D:\\Users\\Szymon\\bron\\serialized.txt");

            ObjectInputStream objectInputStream = new ObjectInputStream(fileInputStream);
            while(true) {
                Object readObject = objectInputStream.readObject();
                if (readObject instanceof Weapon) {
                    weapon = (Weapon) readObject;
                    poDeserializacji.add(weapon);
                }
            }
//           fileInputStream.close();
        } catch (IOException | ClassNotFoundException e) {
            System.out.println("Wszystko sie zdeserializowalo!");
        }
    }

    public Set<Weapon> getWczytaneBronie() {
        return wczytaneBronie;
    }

    public Set<Caliber> getKalibryBroni() {
        return kalibryBroni;
    }

    public Map<Caliber, List<Weapon>> getGroupedWeapons() {
        return groupedWeapons;
    }

    public List<Weapon> getPoDeserializacji() {
        return poDeserializacji;
    }
}
