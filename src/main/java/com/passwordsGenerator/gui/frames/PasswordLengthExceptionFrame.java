package com.passwordsGenerator.gui.frames;

import com.passwordsGenerator.gui.buttons.CloseButton;
import com.passwordsGenerator.exceptions.PasswordLengthException;
import javax.swing.*;
import java.awt.*;


public final class PasswordLengthExceptionFrame extends JFrame {

    private static PasswordLengthExceptionFrame passwordLengthExceptionFrameInstance = null;


    private PasswordLengthExceptionFrame() throws HeadlessException {}


    public static PasswordLengthExceptionFrame getInstance() {

        if (passwordLengthExceptionFrameInstance == null) {

            passwordLengthExceptionFrameInstance = new PasswordLengthExceptionFrame();
            return passwordLengthExceptionFrameInstance;

        } else {

            return passwordLengthExceptionFrameInstance;

        }

    }


    public void showWarning() {
        JFrame warningFrame = new JFrame("Attention");
        CloseButton closeButton = new CloseButton("Close", warningFrame);
        JTextField textField = new JTextField();
        textField.setText(PasswordLengthException.MESSAGE);
        textField.setEditable(false);
        warningFrame.getContentPane().add(BorderLayout.CENTER, textField);
        warningFrame.getContentPane().add(BorderLayout.SOUTH, closeButton);
        warningFrame.setSize(300, 100);
        warningFrame.setLocationRelativeTo(null);
        warningFrame.setVisible(true);
    }

}
