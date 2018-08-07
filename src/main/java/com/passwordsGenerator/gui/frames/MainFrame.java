package com.passwordsGenerator.gui.frames;

import com.passwordsGenerator.gui.panels.*;
import org.apache.log4j.Logger;
import javax.swing.*;
import java.awt.*;


public final class MainFrame {

    public final static Logger LOGGER = Logger.getLogger(MainFrame.class);
    private static MainFrame getMainFrameInstance = null;
    private CenterPanel centerPanel = CenterPanel.getInstance();
    private NorthPanel northPanel = NorthPanel.getInstance();
    private WestPanel westPanel = WestPanel.getInstance();
    private SouthPanel southPanel = SouthPanel.getInstance();


    private MainFrame (){}


    public static MainFrame getInstance() {

        if (getMainFrameInstance == null) {

            getMainFrameInstance = new MainFrame();
            LOGGER.info("Application started");
            return getMainFrameInstance;

        } else {

            return getMainFrameInstance;

        }

    }


    public void run() {

        JFrame frame = new JFrame("Passwords generator");
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        frame.setLocationRelativeTo(null);
        frame.getContentPane().add(BorderLayout.NORTH, northPanel);
        frame.getContentPane().add(BorderLayout.WEST, westPanel);
        frame.getContentPane().add(BorderLayout.CENTER, centerPanel);
        frame.getContentPane().add(BorderLayout.SOUTH, southPanel);
        frame.setSize(400,240);
        frame.setVisible(true);

    }


}
