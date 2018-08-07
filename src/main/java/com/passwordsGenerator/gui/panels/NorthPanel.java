package com.passwordsGenerator.gui.panels;

import com.passwordsGenerator.exceptions.PasswordLengthException;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;


public final class NorthPanel extends JPanel {

    private static NorthPanel northPanelInstance = null;
    private JCheckBox createFile = new JCheckBox("Create file on pulpit");
    private JTextField length;


    private NorthPanel() {}


    public static NorthPanel getInstance() {

        if (northPanelInstance == null) {

            northPanelInstance = new NorthPanel();
            northPanelInstance.createNorthPanel();
            return northPanelInstance;

        } else {

            return northPanelInstance;

        }

    }


    private void createNorthPanel() {

        northPanelInstance.setLayout(new FlowLayout());
        JLabel label = new JLabel("Password length: ");
        label.setPreferredSize(new Dimension(120, 30));
        length = new JTextField();
        length.setPreferredSize(new Dimension(100, 30));
        label.setPreferredSize(new Dimension(120, 30));
        createFile.addItemListener(new CreateFileCheckBoxItemListener());
        northPanelInstance.add(label);
        northPanelInstance.add(length);
        northPanelInstance.add(createFile);

    }


    protected final JTextField getLength() throws PasswordLengthException {

        if (length.getText().equals("")) {

            throw new PasswordLengthException();

        }

        return length;

    }


    protected final JCheckBox getCreateFile() {
        return createFile;
    }


    private class CreateFileCheckBoxItemListener implements ItemListener {


        @Override
        public void itemStateChanged(ItemEvent e) {}


    }


}
