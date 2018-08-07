# Passwords Generator application



Application is based on four collections :

    - 26 small letters (a - z)

    - 26 big letters (A - Z)

    - 10 digits (0 - 9)

    - 27 special characters (see class SpecialCharacters - all characters from keyboard)

All these collections of signs are not mandatory, if someone wants to create password

containing only digits there is a panel with options of selecting collections.

You must select at least one option.




When user entries a password length, the application generates password

and shows it into new window. There is also possibility of creating a txt file

with password on pulpit when the option "create file on desktop" is selected.

Application will create a directory "passwords" on pulpit

and will place all created passwords right there.




In this project there is used a library to logging users activity and collecting

warnings and errors:            --->>> org.apache.log4j <<<---

All logs are saving into file log4j-application.log which is located into resources directory




GUI is created by using library:        --->>> Swing <<<---

Open screenshot.jpg to see the GUI.









