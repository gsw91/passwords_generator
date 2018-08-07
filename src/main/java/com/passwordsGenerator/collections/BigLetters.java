package com.passwordsGenerator.collections;

import java.util.*;


public final class BigLetters implements Signs {

    private List<Character> bigLettersList;
    private static BigLetters BIG_LETTERS_INSTANCE = null;


    public static BigLetters getInstance() {

        if (BIG_LETTERS_INSTANCE == null ) {
            BIG_LETTERS_INSTANCE = new BigLetters();
            BIG_LETTERS_INSTANCE.configureBigLettersList();
            return BIG_LETTERS_INSTANCE;
        } else {
            return BIG_LETTERS_INSTANCE;
        }

    }


    private BigLetters() {}


    @Override
    public final List<Character> getCollection() {
        return bigLettersList;
    }


    private void configureBigLettersList() {

        bigLettersList = new ArrayList<>();
        char a = 'A';
        while (a != 'Z') {
            bigLettersList.add(a);
            a++;
        }
        bigLettersList.add(a);

    }


}
