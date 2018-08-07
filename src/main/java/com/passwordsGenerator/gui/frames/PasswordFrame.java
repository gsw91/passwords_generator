package com.passwordsGenerator.gui.frames;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;


public final class PasswordFrame extends JFrame {

    private final JFrame passwordFrame = new JFrame("Password");
    private final JLabel passwordLabel = new JLabel("Your password");
    private final JButton closeButton = new JButton("Close");


    public final void createFrame(String password) {

        passwordFrame.setLayout(new BorderLayout());
        passwordFrame.setSize(300, 100);
        passwordLabel.setText(password);
        closeButton.addActionListener(new CloseButtonListener());
        passwordFrame.getContentPane().add(BorderLayout.CENTER, passwordLabel);
        passwordFrame.getContentPane().add(BorderLayout.SOUTH, closeButton);
        passwordFrame.setLocationRelativeTo(null);
        passwordFrame.setVisible(true);

    }


    private class CloseButtonListener implements ActionListener {


        @Override
        public void actionPerformed(ActionEvent e) {
            passwordFrame.dispatchEvent(new WindowEvent(passwordFrame, WindowEvent.WINDOW_CLOSING));
        }


    }


}
