package com.company;

import Roboty.RobotDomowy;
import Roboty.SztucznaIntelignecja;
import Roboty.enumy.Nazwa;
import Roboty.enumy.ReperezentacjaDanych;

import java.time.LocalDate;

public class Main {

    public static void main(String[] args) {
        SztucznaIntelignecja sztucznaIntelignecja = new SztucznaIntelignecja(ReperezentacjaDanych.przyblizona);
        RobotDomowy domowy = new RobotDomowy(LocalDate.now(), Nazwa.Ala2,51453, sztucznaIntelignecja);
        RobotDomowy[] domowe;
        System.out.println(domowy);
        domowy.powitanie();
    }
}
