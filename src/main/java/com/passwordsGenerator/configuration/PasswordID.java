package com.passwordsGenerator.configuration;

import org.apache.log4j.Logger;
import java.io.*;


public final class PasswordID {

    private final static Logger LOGGER = Logger.getLogger(PasswordID.class);
    private final String absolutePath = new File("").getAbsolutePath();
    private final String filePath = absolutePath + "\\src\\main\\resources\\passwordNumber.txt";


    protected final int getPasswordId() throws FileNotFoundException {

        try {

            FileReader fileReader = new FileReader(filePath);
            BufferedReader bufferedReader = new BufferedReader(fileReader);
            String textLine = bufferedReader.readLine();
            return Integer.valueOf(textLine);

        } catch (IOException e) {

            LOGGER.error("No file with next password id found");
            throw new FileNotFoundException();

        }

    }

    protected final void setNextPasswordNumber() {

        try {

            int currentPasswordNumber = getPasswordId();
            currentPasswordNumber++;

            try {

                FileWriter fileWriter = new FileWriter(filePath);
                BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);
                bufferedWriter.write(String.valueOf(currentPasswordNumber));
                bufferedWriter.close();

            } catch (IOException e) {

                LOGGER.warn("Cant set next id ");

            }

        } catch (FileNotFoundException e) {

            LOGGER.error("No file with next password id found");

        }

    }


}
