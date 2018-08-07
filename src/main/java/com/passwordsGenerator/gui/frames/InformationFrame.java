package com.passwordsGenerator.gui.frames;

import com.passwordsGenerator.gui.buttons.CloseButton;
import org.apache.log4j.Logger;
import javax.swing.*;
import java.awt.*;
import java.io.*;


public final class InformationFrame extends JFrame {

    private final static Logger LOGGER = Logger.getLogger(InformationFrame.class);
    private static InformationFrame informationFrameInstance = null;
    private final JFrame frame = new JFrame("Information");
    private final CloseButton closeButton = new CloseButton("Close", frame);


    private InformationFrame() throws HeadlessException {}


    public static InformationFrame getInstance() {

        if (informationFrameInstance == null) {

            informationFrameInstance = new InformationFrame();
            return informationFrameInstance;

        } else {

            return informationFrameInstance;

        }

    }


    public final void showInformationFrame() {

        JTextArea textArea = new JTextArea();
        setInformation(textArea);
        textArea.setEditable(false);
        frame.getContentPane().add(BorderLayout.CENTER, textArea);
        frame.getContentPane().add(BorderLayout.SOUTH, closeButton);
        frame.pack();
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);

    }


    private void setInformation(JTextArea jTextArea) {

        String absolutePath = new File("").getAbsolutePath();
        String filePath = absolutePath + "\\src\\main\\resources\\information.txt";

        try {

            String textLine;
            FileReader fr = new FileReader(filePath);
            BufferedReader reader = new BufferedReader(fr);

            while((textLine = reader.readLine()) != null) {

                if (!textLine.startsWith(">"))
                {
                    jTextArea.append(textLine + "\n");
                }

            }
            LOGGER.info("User opened information frame");

        } catch (IOException e) {

            jTextArea.setText("Ops... something gone wrong...");
            LOGGER.warn("Information file not found");

        }

    }


}