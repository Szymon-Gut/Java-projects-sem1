package com.company;

import Action.Initializer;

import java.io.FileNotFoundException;


public class Main {

    public static void main(String[] args) throws FileNotFoundException {
        Initializer initializer = new Initializer();
        initializer.wczytaj();
        System.out.println("\n\n\n\n\n\n");
        initializer.group();
        initializer.zapisz();
        initializer.serializuj();
        initializer.deserializuj();
        System.out.println(initializer.getPoDeserializacji().size());
        System.out.println(initializer.getPoDeserializacji());
        initializer.wczytajLineReader();
    }
}
