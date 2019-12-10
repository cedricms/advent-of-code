package com.adventofcode.challenge2019;

import java.util.HashMap;
import java.util.Map;

public class Day4 extends Day {

    public int getNumberOfPasswordsPart1(String input) {
        String[] inputValues = input.split("-");

        String minString = inputValues[0];
        int minInt = Integer.parseInt(minString);
        String maxString = inputValues[1];
        int maxInt = Integer.parseInt(maxString);

        int result = 0;

        for(int i = minInt; i <= maxInt; i++) {
            if (isPasswordValidPart1(Integer.toString(i))) {
                result++;
            }
        }

        return result;
    }

    public boolean isPasswordValidPart1(String password) {
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

    public int getNumberOfPasswordsPart2(String input) {
        String[] inputValues = input.split("-");

        String minString = inputValues[0];
        int minInt = Integer.parseInt(minString);
        String maxString = inputValues[1];
        int maxInt = Integer.parseInt(maxString);

        int result = 0;

        for(int i = minInt; i <= maxInt; i++) {
            if (isPasswordValidPart2(Integer.toString(i))) {
                result++;
            }
        }

        return result;
    }

    public boolean isPasswordValidPart2(String password) {
        if (password != null
            && password.length() == 6) {
            String previousValue = null;
            int multipleAdjacentDigits = 1;
            Map<Integer, Integer> multipleAdjacentDigitsMap = new HashMap<>();

            for(int i = 0; i < password.length(); i++) {
                String cursor = password.substring(i, i + 1);

                int intCursor = Integer.parseInt(cursor);

                if (previousValue != null) {
                    int intPreviousValue = Integer.parseInt(previousValue);

                    if (intPreviousValue == intCursor) {
                        multipleAdjacentDigits++;
                        multipleAdjacentDigitsMap.put(intCursor, multipleAdjacentDigits);
                    } else if (intPreviousValue > intCursor) {
                        return false;
                    } else {
                        multipleAdjacentDigits = 1;
                    }
                }

                previousValue = cursor;
            }

            for (Map.Entry<Integer, Integer> value : multipleAdjacentDigitsMap.entrySet()) {
                if (value.getValue() == 2) {
                    return true;
                }
            }
        }

        return false;
    }
}