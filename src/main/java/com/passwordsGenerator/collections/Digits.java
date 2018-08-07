package com.passwordsGenerator.collections;

import java.util.*;


public final class Digits implements Signs {

    private List<Integer> digitsList;
    private static Digits DIGITS_INSTANCE = null;


    public static Digits getInstance() {

        if (DIGITS_INSTANCE == null ) {
            DIGITS_INSTANCE = new Digits();
            DIGITS_INSTANCE.configureDigitLists();
            return DIGITS_INSTANCE;
        } else {
            return DIGITS_INSTANCE;
        }

    }

    private Digits() {}


    @Override
    public final List<Integer> getCollection() {
        return digitsList;
    }


    private void configureDigitLists() {

        digitsList = new ArrayList<>();
        for (int i = 0; i < 10; i ++) {
            digitsList.add(i);
        }

    }


}
