package com.adventofcode.challenge2019;

import java.util.List;

public class Day2 extends Day {

    public String processIntcodePart1(String inputFilePath) {
        List<Integer> dataList = this.readFileWithCommasToIntegerList(inputFilePath);

        int[] data = convertListToIntArray(dataList);

        data = processIntcodePart1BusinessRules(data);

        return convertListToCommaSeperatedString(data);
    }

    private int[] processIntcodePart1BusinessRules(int[] data) {
        int instructionPointer = 0;
        while (instructionPointer < data.length) {
                int instruction = data[instructionPointer];

            if (instruction != 99) {
                int parameter1 = data[instructionPointer + 1];
                int parameter2 = data[instructionPointer + 2];
                int parameter3 = data[instructionPointer + 3];

                switch (instruction) {
                    case 1 :
                        data[parameter3] = data[parameter1] + data[parameter2];
                        break;
                    case 2 :
                        data[parameter3] = data[parameter1] * data[parameter2];
                        break;
                    default :
                        break;
                }
            } else {
                break;
            }

            instructionPointer = instructionPointer + 4;
        }

        return data;
    }

    private int[] convertListToIntArray(List<Integer> dataList) {
        if (dataList != null) {
            int[] data = new int[dataList.size()];

            for(int i = 0 ; i < dataList.size() ; i++) {
                data[i] = dataList.get(i).intValue();
            }

            return data;
        } else {
            return null;
        }
    }

    private String convertListToCommaSeperatedString(int[] data) {
        StringBuilder stringBuilder = new StringBuilder();

        for(int i = 0 ; i < data.length ; i++) {
            if (i > 0) {
                stringBuilder.append(",");
            }

            stringBuilder.append(data[i]);
        }

        return stringBuilder.toString();
    }

    public String processIntcodePart1WithCorrectedData(String inputFilePath) {
        List<Integer> dataList = this.readFileWithCommasToIntegerList(inputFilePath);

        int[] data = convertListToIntArray(dataList);

        data = correctDataPart1(data);

        data = processIntcodePart1BusinessRules(data);

        return convertListToCommaSeperatedString(data);
    }

    private int[] correctDataPart1(int[] data) {
        data[1] = 12;
        data[2] = 2;

        return data;
    }

    public String findNounAndVerbByOutput(String inputFilePath, String output) {
        String result = "";

        for (int noun = 0; noun <= 99; noun++) {
            for (int verb = 0; verb <= 99; verb++) {
                List<Integer> dataList = this.readFileWithCommasToIntegerList(inputFilePath);

                int[] data = convertListToIntArray(dataList);

                data[1] = noun;
                data[2] = verb;

                data = processIntcodePart1BusinessRules(data);

                if (output.equals(Integer.toString(data[0]))) {
                    return Integer.toString((100 * noun) + verb);
                }
            }
        }

        return result;
    }
}