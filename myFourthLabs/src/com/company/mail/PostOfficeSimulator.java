package com.company.mail;

import com.company.mail.letter.Letter;
import com.company.mail.letter.LoveLetter;
import com.company.mail.letter.NormalLetter;
import com.company.mail.letter.Postcard;

public class PostOfficeSimulator {

    public static void main(String[] args) {
        Mailbox mailbox = new Mailbox();
        Letter letter = new Postcard("Hello how r u?");
        // letter.getAuthor();  daloby sie wywolac gdyby public byla

        Letter myNormalLetter = new NormalLetter("My normal letter");
        // NormalLetter check = new Letter("castowanie w góre- bez sensu!!!!");
        // mozna zcastowac - ale to bez sensu na obietkach zlozonych (na prymitywach najwyzej stracimy informacje)
        // NormalLetter check = (normalLetter)(Letter(""));    not sure - czy dobrze przepisane
        NormalLetter normalLetter = new NormalLetter("This is normal letter");

        NormalLetter check = new NormalLetter("");
        check.readMe(); // pusty

        System.out.println();

        mailbox.putMail(letter);
        mailbox.putMail(myNormalLetter);
        mailbox.putMail(normalLetter);

        System.out.println();

        Postcard postcard = new Postcard("Greetings from Warsaw");
        mailbox.putMail(postcard);

        LoveLetter loveLetter = new LoveLetter("I love u");
        mailbox.putMail(loveLetter);

    }

}
