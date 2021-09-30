package com.company;

import Bron.Caliber;
import Bron.Weapon;

import java.io.LineNumberReader;
import java.io.Reader;

public class LineNumberReaderExtended extends LineNumberReader {
    private String currentLine;
    private static int i = 0;
    public LineNumberReaderExtended(Reader in) {
        super(in);
    }

    public String getCurrentLine() {
        return currentLine;
    }

    public void setCurrentLine(String currentLine) {
        this.currentLine = currentLine;
    }

    public Weapon getWeapon() {
        Weapon weapon = null;
        if (!currentLine.matches(".*serial.*")) {
            i++;
            String[] tablicaString = currentLine.split(";");
            String[] doCalibru = tablicaString[1].split(" ");
            if (doCalibru.length == 2) {
                weapon = new Weapon(tablicaString[0], new Caliber(doCalibru[0], doCalibru[1]),
                        Double.parseDouble(tablicaString[2].replace(",", ".")), Boolean.parseBoolean(tablicaString[3]));
            } else if (doCalibru.length == 1){
                weapon = new Weapon(tablicaString[0], new Caliber(doCalibru[0], " "),
                        Double.parseDouble(tablicaString[2].replace(",", ".")), Boolean.parseBoolean(tablicaString[3]));
            }
        } else {
            i++;
            String[] tablicaString = currentLine.split(";");
            String[] doCalibru = tablicaString[1].split(" ");
            if (doCalibru.length == 2) {
                weapon = new Weapon(tablicaString[0], new Caliber(doCalibru[0], doCalibru[1]), Integer.parseInt(tablicaString[2].substring(7)),
                        Double.parseDouble(tablicaString[3].replace(",", ".")), Boolean.parseBoolean(tablicaString[4]));
            } else if (doCalibru.length == 1){
                weapon = new Weapon(tablicaString[0], new Caliber(doCalibru[0], " "), Integer.parseInt(tablicaString[2].substring(7)),
                        Double.parseDouble(tablicaString[3].replace(",", ".")), Boolean.parseBoolean(tablicaString[4]));
            }
        }
        if (currentLine.matches(".*Carbine.*")) {
            System.out.println("Karabin!!!");
        } else if (currentLine.matches(".*Rak.*") || currentLine.matches(".*Glauberyt.*") || currentLine.matches(".*p-83.*")) {
            System.out.println("Polski sprzet!");
        }
        System.out.println(i);
        return weapon;
    }
    
}
