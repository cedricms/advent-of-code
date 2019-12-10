package com.adventofcode.challenge2019;

public class Day4 extends Day {

    public int getNumberOfPasswords(String input) {

        return 0;
    }

    public boolean isPasswordValid(String password) {
        if (password != null
            && password.length() == 6) {
                String previousValue = null;
                boolean doubleAdjacentDigits = false;

                for(int i = 0; i < password.length(); i++) {
                    String cursor = password.substring(i, i + 1);

                    int intCursor = Integer.parseInt(cursor);

                    if (previousValue != null) {
                        int intPreviousValue = Integer.parseInt(previousValue);

                        if (intPreviousValue == intCursor) {
                            doubleAdjacentDigits = true;
                        } else if (intPreviousValue > intCursor) {
                            return false;
                        }
                    }

                    previousValue = cursor;
                }

                return doubleAdjacentDigits;
            }

        return false;
    }
}