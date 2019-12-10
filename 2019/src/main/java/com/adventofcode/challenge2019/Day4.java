package com.adventofcode.challenge2019;

public class Day4 extends Day {

    public int getNumberOfPasswords(String input) {
        String[] inputValues = input.split("-");

        String minString = inputValues[0];
        int minInt = Integer.parseInt(minString);
        String maxString = inputValues[1];
        int maxInt = Integer.parseInt(maxString);

        int result = 0;

        for(int i = minInt; i <= maxInt; i++) {
            if (isPasswordValid(Integer.toString(i))) {
                result++;
            }
        }

        return result;
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