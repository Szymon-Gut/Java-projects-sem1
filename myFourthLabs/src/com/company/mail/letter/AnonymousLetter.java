package com.company.mail.letter;

public class AnonymousLetter extends Letter{

    public AnonymousLetter(String text) {
        super(text);
    }

    @Override
    protected String getAuthor() {
        return "Anonymous";
    }

}
