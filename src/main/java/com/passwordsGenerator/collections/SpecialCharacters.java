package com.passwordsGenerator.collections;

import java.util.*;


public final class SpecialCharacters implements Signs {

    private List<Character> specialSignsList;
    private static SpecialCharacters SPECIAL_SIGNS_INSTANCE = null;


    public static SpecialCharacters getInstance() {

        if (SPECIAL_SIGNS_INSTANCE == null ) {
            SPECIAL_SIGNS_INSTANCE = new SpecialCharacters();
            SPECIAL_SIGNS_INSTANCE.configureSpecialSignsList();
            return SPECIAL_SIGNS_INSTANCE;
        } else {
            return SPECIAL_SIGNS_INSTANCE;
        }

    }


    private SpecialCharacters() {}


    @Override
    public final List<Character> getCollection() {
        return specialSignsList;
    }


    private void configureSpecialSignsList() {

        specialSignsList = new ArrayList<>();
        specialSignsList.add('!');
        specialSignsList.add('@');
        specialSignsList.add('#');
        specialSignsList.add('$');
        specialSignsList.add('%');
        specialSignsList.add('^');
        specialSignsList.add('&');
        specialSignsList.add('*');
        specialSignsList.add('(');
        specialSignsList.add(')');
        specialSignsList.add('-');
        specialSignsList.add('_');
        specialSignsList.add('=');
        specialSignsList.add('+');
        specialSignsList.add('{');
        specialSignsList.add('[');
        specialSignsList.add('}');
        specialSignsList.add(']');
        specialSignsList.add('|');
        specialSignsList.add(';');
        specialSignsList.add(':');
        specialSignsList.add('<');
        specialSignsList.add(',');
        specialSignsList.add('.');
        specialSignsList.add('>');
        specialSignsList.add('/');
        specialSignsList.add('?');

        }


}
