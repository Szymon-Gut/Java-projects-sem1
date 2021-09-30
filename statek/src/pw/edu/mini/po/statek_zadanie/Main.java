package pw.edu.mini.po.statek_zadanie;

import pw.edu.mini.po.statek_zadanie.stateek.maszynownia.Maszynownia;
import pw.edu.mini.po.statek_zadanie.stateek.Statek;

public class Main {

    public static void main(String[] args) {
        demonstrator();
    }

    public static void demonstrator(){
        Statek<Maszynownia> statek = new Statek<>(new Maszynownia());
    }
}
