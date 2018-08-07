package com.passwordsGenerator.gui.panels;

import com.passwordsGenerator.collections.*;
import javax.swing.*;
import java.awt.event.*;
import java.util.*;


public final class WestPanel extends JPanel {

    private static WestPanel westPanelInstance = null;
    private List<List> signsList = new ArrayList<>();
    private JCheckBox digitsCheckBox = new JCheckBox("Digits");
    private JCheckBox bigLettersCheckBox = new JCheckBox("Big letters");
    private JCheckBox smallLettersCheckBox = new JCheckBox("Small letters");
    private JCheckBox specialSignsCheckBox = new JCheckBox("Special signs");


    private WestPanel() {}


    public static WestPanel getInstance() {

        if (westPanelInstance == null) {

            westPanelInstance = new WestPanel();
            westPanelInstance.createWestPanel();
            return westPanelInstance;

        } else {

            return westPanelInstance;

        }

    }


    protected final List<List> getSignsList() {
        return signsList;
    }


    private void createWestPanel() {

        westPanelInstance.setLayout(new BoxLayout(westPanelInstance, BoxLayout.Y_AXIS));
        JLabel label = new JLabel("   Select options: \n");
        digitsCheckBox.addItemListener(new DigitsListener());
        bigLettersCheckBox.addItemListener(new BigLettersListener());
        smallLettersCheckBox.addItemListener(new SmallLettersListener());
        specialSignsCheckBox.addItemListener(new SpecialSignsListener());
        westPanelInstance.add(label);
        westPanelInstance.add(digitsCheckBox);
        westPanelInstance.add(bigLettersCheckBox);
        westPanelInstance.add(smallLettersCheckBox);
        westPanelInstance.add(specialSignsCheckBox);

    }


    private class DigitsListener implements ItemListener {


        @Override
        public void itemStateChanged(ItemEvent e) {

            Digits digits = Digits.getInstance();
            List<Integer> digitsList = digits.getCollection();

            if (digitsCheckBox.isSelected()) {

                signsList.add(digitsList);

            } else {

                signsList.remove(digitsList);

            }

        }


    }



    private class BigLettersListener implements ItemListener {


        @Override
        public void itemStateChanged(ItemEvent e) {

            BigLetters bigLetters = BigLetters.getInstance();
            List<Character> bigLettersList = bigLetters.getCollection();

            if (bigLettersCheckBox.isSelected()) {

                signsList.add(bigLettersList);

            } else {

                signsList.remove(bigLettersList);

            }

        }


    }


    private class SmallLettersListener implements ItemListener {


        @Override
        public void itemStateChanged(ItemEvent e) {

            SmallLetters smallLetters = SmallLetters.getInstance();
            List<Character> smallLettersList = smallLetters.getCollection();

            if (smallLettersCheckBox.isSelected()) {

                signsList.add(smallLettersList);

            } else {

                signsList.remove(smallLettersList);

            }

        }


    }


    private class SpecialSignsListener implements ItemListener {


        @Override
        public void itemStateChanged(ItemEvent e) {

            SpecialCharacters specialSigns = SpecialCharacters.getInstance();
            List<Character> specialSignsList = specialSigns.getCollection();

            if (specialSignsCheckBox.isSelected()) {

                signsList.add(specialSignsList);

            } else {

                signsList.remove(specialSignsList);

            }

        }


    }


}
