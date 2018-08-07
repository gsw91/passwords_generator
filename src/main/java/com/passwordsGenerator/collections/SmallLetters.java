package com.passwordsGenerator.collections;

import java.util.*;


public final class SmallLetters implements Signs {

    private List<Character> smallLettersList;
    private static SmallLetters SMALL_LETTERS_INSTANCE = null;


    public static SmallLetters getInstance() {

        if (SMALL_LETTERS_INSTANCE == null ) {
            SMALL_LETTERS_INSTANCE = new SmallLetters();
            SMALL_LETTERS_INSTANCE.configureSmallLettersList();
            return SMALL_LETTERS_INSTANCE;
        } else {
            return SMALL_LETTERS_INSTANCE;
        }

    }

    private SmallLetters() {}


    @Override
    public final List<Character> getCollection() {
        return smallLettersList;
    }


    private void configureSmallLettersList() {

        smallLettersList = new ArrayList<>();
        char a = 'a';
        while (a != 'z') {
            smallLettersList.add(a);
            a++;
        }
        smallLettersList.add(a);

    }


}
