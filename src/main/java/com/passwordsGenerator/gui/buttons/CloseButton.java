package com.passwordsGenerator.gui.buttons;

import javax.swing.*;
import java.awt.event.*;


public final class CloseButton extends JButton {

    private JFrame frame;


    public CloseButton(String text, JFrame frame) {

        super(text);
        this.frame = frame;
        this.addActionListener(new CloseButtonListener());

    }


    private class CloseButtonListener implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            frame.dispatchEvent(new WindowEvent(frame, WindowEvent.WINDOW_CLOSING));
        }

    }


}
