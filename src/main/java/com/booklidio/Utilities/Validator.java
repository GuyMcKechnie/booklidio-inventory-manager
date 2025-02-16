package com.booklidio.Utilities;

public class Validator {

    public boolean validateInput(final String input, final boolean isStringOnly, final boolean isEmail,
            final boolean isCellphone) {
        if (!presenceCheck(input)) {
            System.out.println("Failed presence check.");
            return false;
        }
        if (isStringOnly && !stringOnlyCheck(input)) {
            System.out.println("Failed string only check.");
            return false;
        }
        if (isEmail && !emailCheck(input)) {
            System.out.println("Failed email check.");
            return false;
        }
        if (isCellphone && !cellphoneCheck(input)) {
            System.out.println("Failed cellphone check.");
            return false;
        }
        return true;
    }

    private boolean stringOnlyCheck(final String input) {
        final String stringRegex = "^[a-zA-Z ]+$";
        if (input == null || !input.matches(stringRegex)) {
            return false;
        }
        return true;
    }

    private boolean presenceCheck(final String input) {
        if (input == null || input.isEmpty()) {
            return false;
        }
        return true;
    }

    private boolean emailCheck(final String input) {
        final String emailRegex = "^[A-Za-z0-9._%+-]+@[A-Za-z0-9.-]+\\.[A-Za-z]{2,}$";
        if (input == null || !input.matches(emailRegex)) {
            System.out.println(input);
            return false;
        }
        return true;
    }

    private boolean cellphoneCheck(final String input) {
        final String phoneNumberRegex = "^\\d{10}$";
        if (input == null || !input.matches(phoneNumberRegex)) {
            return false;
        }
        return true;
    }

}
