package com.passwordsGenerator.gui.panels;

import com.passwordsGenerator.configuration.PasswordCreation;
import com.passwordsGenerator.exceptions.PasswordLengthException;
import com.passwordsGenerator.gui.frames.*;
import org.apache.log4j.Logger;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.List;


public final class CenterPanel extends JPanel {

    private final static Logger LOGGER = Logger.getLogger(CenterPanel.class);
    private static CenterPanel centerPanelInstance = null;
    private final WestPanel westPanel = WestPanel.getInstance();
    private final PasswordFrame passwordFrame = new PasswordFrame();


    private CenterPanel() {}


    public static CenterPanel getInstance() {

        if (centerPanelInstance == null) {

            centerPanelInstance = new CenterPanel();
            centerPanelInstance.createCenterPanel();
            return centerPanelInstance;

        } else {

            return centerPanelInstance;

        }

    }


    private void createCenterPanel() {

        JButton generateButton = new JButton("Generate");
        generateButton.setPreferredSize(new Dimension(250, 100));
        generateButton.addActionListener(new GenerateButtonListener());
        centerPanelInstance.setLayout(new FlowLayout());
        centerPanelInstance.add(generateButton);

    }


    private class GenerateButtonListener implements ActionListener {


        @Override
        public void actionPerformed(ActionEvent e) {

            NorthPanel northPanel = NorthPanel.getInstance();
            passwordFrame.dispatchEvent(new WindowEvent(passwordFrame, WindowEvent.WINDOW_CLOSING));
            List<List> signsLists = westPanel.getSignsList();
            PasswordCreation passwordCreation = new PasswordCreation(signsLists);
            String text;

            try {

                text = northPanel.getLength().getText();

                try {

                    int length = passwordCreation.checkDigits(text);

                    try {

                        String password = passwordCreation.createRandomPassword(length);
                        passwordFrame.createFrame(password);
                        LOGGER.info("Password created successfully ");

                        if (northPanel.getCreateFile().isSelected()) {

                            boolean checkCreation = passwordCreation.createNewFileWithPassword(password);
                            if (checkCreation) {
                                LOGGER.info("File with password created in directory");
                            }

                        }

                    } catch (IllegalArgumentException exception) {

                        ListsExceptionFrame listsExceptionFrame = ListsExceptionFrame.getInstance();
                        listsExceptionFrame.showWarning();
                        LOGGER.warn("User did not choose any list of characters");

                    }

                } catch (PasswordLengthException exception) {

                    LOGGER.warn("User entered wrong number");

                }

            } catch (PasswordLengthException exception) {

                LOGGER.warn("No entered value for password length");

            }

        }


    }


}
