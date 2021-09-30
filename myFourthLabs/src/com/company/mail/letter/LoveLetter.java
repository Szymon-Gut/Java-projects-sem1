package com.company.mail.letter;

public class LoveLetter extends Letter {

    public LoveLetter(String text) {
        super(text);
    }

    @Override
    protected String getAuthor() {
        return "Anton";
    }
}
