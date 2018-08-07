package com.passwordsGenerator.gui.frames;

import com.passwordsGenerator.gui.buttons.CloseButton;
import javax.swing.*;
import java.awt.*;


public final class ListsExceptionFrame extends JFrame {

    private static ListsExceptionFrame listsExceptionFrameInstance = null;


    private ListsExceptionFrame() {}


    public static ListsExceptionFrame getInstance() {

        if (listsExceptionFrameInstance == null) {

            listsExceptionFrameInstance = new ListsExceptionFrame();
            return listsExceptionFrameInstance;

        } else {

            return listsExceptionFrameInstance;

        }

    }


    public final void showWarning() {

        JFrame warningFrame = new JFrame("Attention");
        CloseButton closeButton = new CloseButton("Close", warningFrame);
        JTextField textField = new JTextField();
        textField.setText("   Select at least one list of characters");
        textField.setEditable(false);
        warningFrame.getContentPane().add(BorderLayout.CENTER, textField);
        warningFrame.getContentPane().add(BorderLayout.SOUTH, closeButton);
        warningFrame.setSize(300, 100);
        warningFrame.setLocationRelativeTo(null);
        warningFrame.setVisible(true);

    }


}
