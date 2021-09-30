package com.company.mail.letter;

public class Postcard extends Letter {
    public Postcard(String text) {
        super(text);
    }

    @Override
    protected String getAuthor() {
        return "Stanislaw";
    }
}
