package com.passwordsGenerator.configuration;

import com.passwordsGenerator.exceptions.PasswordLengthException;
import org.apache.log4j.Logger;
import java.io.*;
import java.nio.file.*;
import java.util.*;


public final class PasswordCreation {

    private final static Logger LOGGER = Logger.getLogger(PasswordCreation.class);
    private final PasswordID passwordID = new PasswordID();
    private final Random random = new Random();
    private List<List> signsList;


    public PasswordCreation(List<List> signsList) {
        this.signsList = signsList;
    }


    public final boolean createNewFileWithPassword(final String password) {

        String pathToFolder = System.getProperty("user.home") + "/Desktop/Passwords";
        createFolderIfNotExists(pathToFolder);
        return createPasswordFile(password, pathToFolder);

    }


    private void createFolderIfNotExists(String path) {

        Path directoryPath = Paths.get(path);
        if (!Files.exists(directoryPath)) {

            try {

                LOGGER.info("Creating new folder for passwords");
                Files.createDirectories(directoryPath);

            } catch (IOException e) {

                LOGGER.warn("New folder creation failed");

            }

        }

    }


    private boolean createPasswordFile(String password, String pathToFolder) {

        try {

            int passwordId = passwordID.getPasswordId();
            String fileName = "/password" + passwordId + ".txt";
            File file = new File(pathToFolder + fileName);
            FileWriter fileWriter = new FileWriter(file);
            BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);
            bufferedWriter.write("Your password: " + password);
            bufferedWriter.close();
            passwordID.setNextPasswordNumber();
            return true;

        } catch (IOException e) {

            LOGGER.warn("Password file creation failed");
            return false;

        }

    }


    public final String createRandomPassword(final int length) throws IllegalArgumentException {

        StringBuilder passwordBuilder = new StringBuilder();

        if (signsList.size() == 0) {

            throw new IllegalArgumentException();

        } else {

            while (passwordBuilder.length() != length) {
                int list = random.nextInt(signsList.size());
                List currentList = signsList.get(list);
                int position = random.nextInt(currentList.size() - 1);
                passwordBuilder.append(currentList.get(position));

            }

            return passwordBuilder.toString();

        }

    }


    public final int checkDigits(String text) throws PasswordLengthException {

        StringBuilder stringBuilder = new StringBuilder();
        int textLength = text.length();

        for (int i = 0; i < textLength; i++) {

            String digit = text.substring(i, i + 1);
            switch (digit) {
                case "0":
                    stringBuilder.append(digit);
                    break;
                case "1":
                    stringBuilder.append(digit);
                    break;
                case "2":
                    stringBuilder.append(digit);
                    break;
                case "3":
                    stringBuilder.append(digit);
                    break;
                case "4":
                    stringBuilder.append(digit);
                    break;
                case "5":
                    stringBuilder.append(digit);
                    break;
                case "6":
                    stringBuilder.append(digit);
                    break;
                case "7":
                    stringBuilder.append(digit);
                    break;
                case "8":
                    stringBuilder.append(digit);
                    break;
                case "9":
                    stringBuilder.append(digit);
                    break;
                default:
                    throw new PasswordLengthException();
            }

        }

        int value = Integer.valueOf(stringBuilder.toString());
        if (value == 0) {
            throw new PasswordLengthException();
        }
        return value;

    }


}