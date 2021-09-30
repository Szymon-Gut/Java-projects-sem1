package pl.edu.pw.mini.po;
import pl.edu.pw.mini.po.additional.Human;

import java.util.SortedMap;

public class Main {

    public static void main(String[] args) {

        //first();

        second();

    }
    private static void second(){

        String myString = "aaaa";
        myString = new String("hello");

//        System.out.println(" My string : "+myString.substring(3));
        System.out.println(" My string : "+myString + "aaa");

        String first = new String("jan");
        String second = new String("jan");

//        if(first == second){ // porownanie odnosnikow
        /*
        jesli damy np
            String first = "jan";
            String second = "jan";
            to porownanie odnosnikow zwroci prawde (wsk na to samo na stosie)
         */
        if(first.equals(second)){
            System.out.println("The same");
        } else {
            System.out.println("Not the same");
        }

        //zawsze uzywac if(smth!=null && ...)

    }
    private static void first(){
//        System.out.printf("Hello!");
        Object object = new Object();
        System.out.printf("My object "+object);

//        Human human = new Human(); // konstruktor


//        human.age = 10;
//        human.name = "Piotr" // brak dostepu
//        private - tylko dla klasy, protected dla podklas

//        human.age = 10;
//        human.name = "Piotr";
//        human.surname = "Kowalski";
//        human.weight = 78.7;

        Human earlyHuman = new Human(); // pusty obiekt nie przejdzie gdy jest konstruktor, ale jak jest pusty obiekt human bezparametrowo to git

        Human human = new Human(10,"Piotr", "Kowalski");
        Human human2 = new Human(10,"Jacek","Y");
        System.out.println("Human 1: "+human.name+ ", Human 2: "+human2.name);
        /*

            jakis kod

         */

//        human.weight = 70.3; // pozniejsze zadeklarowanie itp

        human.myMethod(10,1.5,1,2,3,4,6);

//        human.counter = 1;//dziala ale nie robic
    }
}
