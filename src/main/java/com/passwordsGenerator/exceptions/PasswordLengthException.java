package com.passwordsGenerator.exceptions;

import com.passwordsGenerator.gui.frames.PasswordLengthExceptionFrame;


public final class PasswordLengthException extends NumberFormatException {

    public static String MESSAGE = "    Specify the correct password length!";


    public PasswordLengthException() {
        PasswordLengthExceptionFrame exceptionFrame = PasswordLengthExceptionFrame.getInstance();
        exceptionFrame.showWarning();
    }


    @Override
    public final String getMessage() {
        return MESSAGE;
    }


}
