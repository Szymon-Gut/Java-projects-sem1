package com.company.mail.letter;

// jak nie bedziemy robic instacji to abstract nalezy uzywac

public abstract class Letter {

    protected abstract String getAuthor();

    protected String text;

    public Letter(String text) {
        this.text = text;
    }

    public void readMe(){
        System.out.println("Letter read: " + text);
    }

}
