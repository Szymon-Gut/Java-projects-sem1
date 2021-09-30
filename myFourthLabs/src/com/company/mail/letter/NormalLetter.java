package com.company.mail.letter;

public class NormalLetter extends Letter{

    public NormalLetter(String text) {
        super(text);
    }

    protected String getAuthor() {
        return "Maciek";
    }

    public void readMe() {
        System.out.println("This is normal letter: " + text);
    }

}
