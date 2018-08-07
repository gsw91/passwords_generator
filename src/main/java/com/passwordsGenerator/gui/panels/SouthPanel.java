package com.passwordsGenerator.gui.panels;

import com.passwordsGenerator.gui.frames.*;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;


public final class SouthPanel extends JPanel {

    private static SouthPanel southPanelInstance = null;


    private SouthPanel(){}


    public static SouthPanel getInstance() {

        if (southPanelInstance == null) {

            southPanelInstance = new SouthPanel();
            southPanelInstance.createSouthPanel();
            return southPanelInstance;

        } else {

            return southPanelInstance;

        }

    }


    private void createSouthPanel() {

        southPanelInstance.setLayout(new BorderLayout());
        JButton exitButton = new JButton("Exit");
        exitButton.setPreferredSize(new Dimension(200, 30));
        exitButton.addActionListener(new ExitButtonListener());
        JButton infoButton = new JButton("Info");
        infoButton.setPreferredSize(new Dimension(200, 30));
        infoButton.addActionListener(new InformationButtonListener());
        southPanelInstance.add(BorderLayout.WEST, exitButton);
        southPanelInstance.add(BorderLayout.EAST, infoButton);

    }


    private class ExitButtonListener implements ActionListener {


        @Override
        public void actionPerformed(ActionEvent e) {

            try {

                Thread.sleep(500);
                MainFrame.LOGGER.info("Application closed");

            } catch (Exception exception) {

                System.out.println(exception.getMessage());

            }

            System.exit(0);

        }


    }


    private class InformationButtonListener implements ActionListener {


        @Override
        public void actionPerformed(ActionEvent e) {

            InformationFrame frame = InformationFrame.getInstance();
            frame.showInformationFrame();

        }


    }



}
